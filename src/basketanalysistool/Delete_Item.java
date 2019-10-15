package basketanalysistool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Delete_Item extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
	JTextField id,name;
	Container c;
	JButton del,home;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname;
	int t=0;
        int flag=0;
	public Delete_Item()
	{
		super("Delete Item");
		c = getContentPane();
		c.setLayout(null); 
		setBounds(150,150,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		del = new JButton("Delete"); 
		del.setToolTipText("To Delete Item");
		home = new JButton("Home"); 
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(240,300,70,30);
		home.addActionListener(this);
		c.add(home);
		 lname.setBounds(70,120,670,20);
                lid.setBounds(70,150,150,20);
              
		name.setBounds(190,120,150,20);
		id.setBounds(190,150,150,20);
                
		del.setBounds(80,300,70,30);
		del.addActionListener(this);
		c.add(lname);
                c.add(lid);
		c.add(name);
                		c.add(id);
		c.add(del);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==del)
		{
			 try{
        conn=MysqlConnect.ConnectDB();
         
        String Sql="DELETE FROM items WHERE Item_name =?";
        pst =conn.prepareStatement(Sql);
       pst.setString(1,name.getText());
        pst.executeUpdate();
       pst.setInt(1,1);
       jp.showMessageDialog(this,"Record Deleted sucessfuly","DELETED",jp.INFORMATION_MESSAGE);
					flag=1;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}
        
 		}
		
		if(source==home)
		{
                        this.dispose();
		}
	}	
	public void n5()//public static void main(String arg[])
 	{
	 }
}