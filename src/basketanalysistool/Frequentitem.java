package basketanalysistool;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import java.io.*;

import javax.swing.table.DefaultTableModel;
public class Frequentitem extends JFrame implements ActionListener{
    int mem_id=0,t=0,flag=0;
    Connection conn = null;
    PreparedStatement pst=null;
    JOptionPane jp = new JOptionPane();
    ResultSet rs=null;
DefaultTableModel model;
private FileWriter fw;
private PrintWriter pw;
private BufferedReader br;

JPanel panel;
JScrollPane pane;
JFrame frame;
JTable table,rowTable;
JLabel lmem_ID,AL,BL,CL,DL,EL;
JTextField mem_IDtxt,A,B,C,D,E;
JButton Add,Submit,save,print;

public Frequentitem(){    
     frame= new JFrame("Add Transaction");
  table = new JTable(model);
  model=(DefaultTableModel)table.getModel();
  String[] columns = { "ITEMS"};
 Object[][] data = {};
model = new DefaultTableModel(data,columns);
model.setColumnIdentifiers(columns);
table.setModel(model);
table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
table.setRowSelectionAllowed(true);

//table.setBackground(Color.cyan);
//table.setForeground(Color.white);
Font font = new Font("",1,22);
table.setFont(font);
table.setRowHeight(30);

panel = new JPanel();
 Add = new JButton("ADD ROW");
 print = new JButton("print");
 Submit = new JButton("SUBMIT");
 save=new JButton("save");
 
 AL = new JLabel("NUMBER OF ITEMS ENTERED:");
 BL = new JLabel("TOTAL NO. OF TRANSACTIONS:");
 CL = new JLabel("NO. HAVING THE FIRST ITEM:");
 DL = new JLabel ("SUPPORT COUNT:");
 EL = new JLabel ("PERCENTAGE:");
 
 A = new JTextField(15);
 B = new JTextField(15);
 C = new JTextField(15);
 D = new JTextField(15);
 E = new JTextField(15);
 
 
Add.setBounds(25,310,100,25);
Submit.setBounds(130,310,100,40);
panel.setBounds(260, 25, 350, 250);
print.setBounds(440,320,100,25);
save.setBounds(550,320,100,25);

//panel.setForeground(Color.red);
panel.setBackground(Color.yellow);
AL.setBounds(20,20,200,25);
BL.setBounds(20,55,200,25);
CL.setBounds(20,90,200,25);
DL.setBounds(20,125,200,25);
EL.setBounds(20,160,200,25);

A.setBounds(210,20,50,25);
A.setForeground(Color.black); 
A.setBackground(Color.white);
A.setEditable(false);
A.setHorizontalAlignment(SwingConstants.CENTER);

B.setBounds(210,55,50,25);
B.setForeground(Color.black); 
B.setBackground(Color.white);
B.setEditable(false);
B.setHorizontalAlignment(SwingConstants.CENTER);

C.setBounds(210,90,50,25);
C.setForeground(Color.black); 
C.setBackground(Color.white);
C.setEditable(false);
C.setHorizontalAlignment(SwingConstants.CENTER);

D.setBounds(210,125,50,25);
D.setForeground(Color.black); 
D.setBackground(Color.white);
D.setEditable(false);
D.setHorizontalAlignment(SwingConstants.CENTER);

E.setBounds(210,160,50,25);
E.setForeground(Color.black); 
E.setBackground(Color.white);
E.setEditable(false);
E.setHorizontalAlignment(SwingConstants.CENTER);

 pane = new JScrollPane(table);
pane.setBounds(25,25,180,250);
 rowTable = new RowNumberTable(table);
       pane.setRowHeaderView(rowTable);
       pane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
    rowTable.getTableHeader());
 
panel.setLayout(null); 
panel.add(AL); 
panel.add(BL);
panel.add(CL);
panel.add(DL);
panel.add(EL);
panel.add(A); 
panel.add(B);
panel.add(C);
panel.add(D);
panel.add(E);        
       
frame.setLayout(null);


frame.add(pane);
frame.add(panel);

        frame.add(Add);
        Add.addActionListener(this);
        frame.add(print);
       print.addActionListener(this);
        frame.add(Submit);
        Submit.addActionListener(this);
         frame.add(save);
        save.addActionListener(this);
        


frame.setSize(700,500);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setVisible(true);
//table.selectAll();
}
public void actionPerformed(ActionEvent ae){
        String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==Add){
                    try{
                               addRow();
                    }
                    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}  
        }
if(source==Submit){
     try{
                    Transaction();       
                    
                   
			
			conn=MysqlConnect.ConnectDB();
			t=0;
			
			{
				
				if(t==0)
				{
					t=0;
					PreparedStatement ps  = conn.prepareStatement("insert into transaction values(?,?,?,?,?)");
					if((A.getText()).length()!=0)
					ps.setString(1,A.getText());
					else
					ps.setString(1,"");
					if((B.getText()).length()!=0)
					ps.setString(2,B.getText());	
					else
					ps.setString(2,"");	
                                                                                                            if((C.getText()).length()!=0)
					ps.setString(3,C.getText());
					else
					ps.setString(3,"");
					if((D.getText()).length()!=0)
					ps.setString(4,D.getText());
					else
					ps.setString(4,"");
					if((E.getText()).length()!=0)
					ps.setString(5,E.getText());
					else
					ps.setString(5,"");
					
					ps.executeUpdate();
					jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
					flag=1;
				}
				else
				{
					jp.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
				
			}
			
			conn.close();
			
			}
			
                   catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
                   
                   }
    
}}
 
public void addRow(){
        
        model.addRow(new Object[]{});
        
        } 
//public Object getValueAt(int rowIndex, int columnIndex) {
    // TODO Auto-generated method stub
//}
public void Transaction(){
    int rowcount=table.getRowCount();
    String[] item=new String[rowcount ];
    if(rowcount>0){
    if(table.getSelectedRowCount()>0){
    int SelectedRow[]=table.getSelectedRows();
    for(int i:SelectedRow){
     item[i]=(String)table.getValueAt(i,0);
    }}}
    System.out.println(item);
	try{
	int num_tr=0,support=0,num_item_tr=0;
	float sup_per=0;
	String query="",it=null;
        conn=MysqlConnect.ConnectDB();
	PreparedStatement no_of_tr=conn.prepareStatement("SELECT COUNT(*)FROM (SELECT m.t_id FROM mem_trans m, item_trans i WHERE i.t_id=m.t_id AND i.item_id=?)AS P");
	no_of_tr.setString(1,item[0]);
	 rs=no_of_tr.executeQuery();
	//Number of items entered as input
	int item_count=table.getSelectedRowCount();
	System.out.println("Number of items entered :"+item_count);
        A.setText(""+item_count);
        while(rs.next())
        {
                //getting total number of transactions
                num_tr=rs.getInt(1);
        }
        System.out.println("Total No. of transactions:"+num_tr);
        C.setText(""+num_tr);
        PreparedStatement frq_items=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? ) AS num_tr");
        frq_items.setString(1,item[0]);
        ResultSet rs_count=frq_items.executeQuery();
        while(rs_count.next())
        {
                //number of transactions having the first item
                num_item_tr=rs_count.getInt(1);
        }
        PreparedStatement item_name=conn.prepareStatement("SELECT item_name FROM items WHERE item_id=?");
        item_name.setString(1,item[0]);
        ResultSet item_nm=item_name.executeQuery();
        String first_item=null;
        while(item_nm.next())
        {
                //Item name of the first item
                first_item=item_nm.getString(1);
        }
        System.out.println("Number of transactions having the item "+first_item+": "+num_item_tr);
        B.setText(""+num_item_tr);
        PreparedStatement supp_it=null;
        ResultSet sup=null;
        int supp_count=0;
        if(item_count==1)
        {
                System.out.println("Support :"+(float)(num_item_tr*100/num_tr));
                D.setText(""+(float)(num_item_tr*100/num_tr));
        }
        else if(item_count==2)
        {
                supp_it=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? and t_id in( SELECT t_id FROM item_trans WHERE item_id=?)) AS count2");
                supp_it.setString(1,item[0]);
                supp_it.setString(2,item[1]);
                sup=supp_it.executeQuery();
                while(sup.next())
                {
                        supp_count=sup.getInt(1);

                }

        }
        else if(item_count==3)
        {
                supp_it=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? AND t_id IN( SELECT t_id FROM item_trans WHERE item_id=?) AND  t_id IN (SELECT t_id FROM item_trans WHERE item_id=?)) AS count3");
                supp_it.setString(1,item[0]);
                supp_it.setString(2,item[1]);
                supp_it.setString(3,item[2]);
                sup=supp_it.executeQuery();
                while(sup.next())
                {
                        supp_count=sup.getInt(1);

                }

        }
        else if(item_count==4)
        {
                supp_it=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?)) AS count4");
                supp_it.setString(1,item[0]);
                supp_it.setString(2,item[1]);
                supp_it.setString(3,item[2]);
                supp_it.setString(4,item[3]);
                sup=supp_it.executeQuery();
                while(sup.next())
                {
                        supp_count=sup.getInt(1);

                }

        }
        else if(item_count==5)
        {
                supp_it=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?)) AS count5");
                supp_it.setString(1,item[0]);
                supp_it.setString(2,item[1]);
                supp_it.setString(3,item[2]);
                supp_it.setString(4,item[3]);
                supp_it.setString(5,item[4]);
                sup=supp_it.executeQuery();
                while(sup.next())
                {
                        supp_count=sup.getInt(1);

                }

        }
        else if(item_count==6)
        {
                supp_it=conn.prepareStatement("SELECT COUNT(*) FROM (SELECT t_id FROM item_trans WHERE item_id=? AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?) AND t_id IN (SELECT t_id FROM item_trans WHERE item_id=?)) AS count6");
                supp_it.setString(1,item[0]);
                supp_it.setString(2,item[1]);
                supp_it.setString(3,item[2]);
                supp_it.setString(4,item[3]);
                supp_it.setString(5,item[4]);
                supp_it.setString(6,item[6]);
                sup=supp_it.executeQuery();
                while(sup.next())
                {
                        supp_count=sup.getInt(1);

                }
        }
     
        System.out.println("Support Count :"+supp_count);
        D.setText(""+supp_count);
        int per=supp_count*100/num_item_tr;
        System.out.println("Percentage :"+per+"%");
        E.setText(""+per+" %");
       
	}
        catch(Exception e)
    {

         JOptionPane.showMessageDialog(null, e);
    }
        //String desktopPath= System.getProperty("user.home")+"/Desktop/";
        String filename=new String();
        JFileChooser savefile=new JFileChooser();
        savefile.setSelectedFile(new File(filename));
          int sf=savefile.showSaveDialog(null);
          if(sf==JFileChooser.APPROVE_OPTION){
             try{
          
    //write labels and corresponding fields to text file
    //BufferedWriter outfile=new BufferedWriter(new FileWriter(desktopPath+"analysis.txt"));
    BufferedWriter outfile=new BufferedWriter(new FileWriter(savefile.getSelectedFile()));
    outfile.write("NUMBER OF ITEMS ENTERED:");
    outfile.write(A.getText()+"\n");
    outfile.write("TOTAL NUMBER OF ITEMS:");
    outfile.write(B.getText()+"\n");
    outfile.write("NUMBER OF HAVING FIRST ITEM:");
    outfile.write(C.getText()+"\n");
    outfile.write("SUPPORT COUNT:");
    outfile.write(D.getText()+"\n");
    outfile.write("PERCENTAGE:");
    outfile.write(E.getText()+"\n");
    outfile.close();
   
    JOptionPane.showMessageDialog(this, "saved!");
    }
    catch(FileNotFoundException e){
        System.out.println("File not Found.");
    }
    catch(IOException k){
        System.out.println("IOException.");
    }}else if(sf==JFileChooser.CANCEL_OPTION){
    JOptionPane.showMessageDialog(null,"File cancelled!!");}

}
public void n8(){}

/*public static void main(String[] args){
    EventQueue.invokeLater (new Runnable(){
        @Override
        public void run()
        {
            try
            {
                Frequentitem tb =new Frequentitem();
            }
            catch(Exception e)
            { e.printStackTrace();
            }
        }
    });
    
}*/
}