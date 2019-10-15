package basketanalysistool;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Add_transaction extends JFrame implements ActionListener{
    int mem_id=0;
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
DefaultTableModel model;
JScrollPane pane;
Container c;
JTable table;
JLabel lmem_ID;
JTextField mem_IDtxt;
JButton Add,Home,Submit;
public Add_transaction(){
    super("ADD TRANSACTION");
    c=getContentPane();
 table = new JTable(model);
String[] columns = {"ITEMS"};
Object[][] data = {{},{}};
model = new DefaultTableModel(data,columns);
 
model.setColumnIdentifiers(columns);
table.setModel(model);

//table.setBackground(Color.cyan);
//table.setForeground(Color.white);
Font font = new Font("",1,22);
table.setFont(font);
table.setRowHeight(30);

lmem_ID = new JLabel("ENTER MEMBER ID:");
mem_IDtxt = new JTextField();

lmem_ID.setBounds(0,0,120,25);
mem_IDtxt.setBounds(110,0,60,25);

 Add = new JButton("ADD ROW");
 Submit = new JButton("SUBMIT");
 Home = new JButton("Home");

 
Add.setBounds(90,300,100,25);
Submit.setBounds(190,300,100,25);
Home.setBounds(360,300,100,25);

 pane = new JScrollPane(table);
pane.setBounds(170,50,180,250);
JTable rowTable = new RowNumberTable(table);
       pane.setRowHeaderView(rowTable);
       pane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
    rowTable.getTableHeader());
c.setLayout(null);


c.add(lmem_ID);
c.add(mem_IDtxt);

c.add(pane);

        c.add(Add);
        Add.addActionListener(this);
        c.add(Submit);
        Submit.addActionListener(this);
        c.add(Home);
        Home.addActionListener(this);

setBounds(150,150,500,400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public void actionPerformed(ActionEvent ae){
        String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
                if(source==Home)
		{
                        this.dispose();
		}
		if(source==Add){
                    try{
                               addRow();
                    }
                    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}  
        }
if(source==Submit){
                    try{
                 int rows=table.getRowCount();
                 conn=MysqlConnect.ConnectDB();
                 
                 int last_tr=0;
                 String m_id=null;
        conn=MysqlConnect.ConnectDB();
        String Sql="SELECT * FROM member WHERE mem_ID =?";
        pst =conn.prepareStatement(Sql);
        pst.setString(1,mem_IDtxt.getText());
        rs=pst.executeQuery();
        while(rs.next()){
            
        }
                PreparedStatement get_last_tr=conn.prepareStatement("SELECT t_ID FROM mem_trans ORDER BY t_ID");
             rs=get_last_tr.executeQuery();
		while(rs.next())
		{
			last_tr=rs.getInt(1);
			
		}
		int new_tr=last_tr+1;
		System.out.println(new_tr);
		PreparedStatement mem_tr=conn.prepareStatement("INSERT INTO mem_trans VALUES(?,?)");
		mem_tr.setInt(1,new_tr);
		mem_tr.setInt(2,mem_id);
		mem_tr.executeUpdate();
		
                conn.setAutoCommit(false);
                PreparedStatement item_tr=conn.prepareStatement("INSERT INTO item_trans VALUES(?,?)");
            for(int row=0;row<rows;row++){
            String item_ID=(String)table.getValueAt(row,0);
            item_tr.setInt(1,new_tr);
            item_tr.setString(2,item_ID);
            
            item_tr.addBatch();  
            item_tr.executeUpdate();
            }
            item_tr.executeBatch();
            conn.commit();
            JOptionPane.showMessageDialog(null,"Transaction successful added", "        SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    }
                   catch(Exception e){
                   JOptionPane.showMessageDialog(this,e.getMessage());}}}
public void addRow(){
        model=(DefaultTableModel)
                table.getModel();
        model.addRow(new String[]{""});
        }      
public void n7()//public static void main(String[] args)
        {
    //Add_transaction tb =new Add_transaction();
}
}