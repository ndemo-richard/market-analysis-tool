package basketanalysistool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPopupMenu;
public class Delete_Member extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
	JTextField id;
	Container c;
	JButton Del,home;
	int t=0,flag=0;
	JOptionPane jp = new JOptionPane();
	JLabel lid;
	public Delete_Member()
	{
            super("Delete Member");
		c = getContentPane();
		c.setLayout(null); 
		setBounds(0,0,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		/*lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		lsex = new JLabel("Gender :");  
		lsex.setForeground(Color.black);
		lemail = new JLabel("Email:");  
		lemail.setForeground(Color.black);
		lpho = new JLabel("Phone Number :");  
		lpho.setForeground(Color.black);*/
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		/*name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		sex = new JTextField(); 
		sex.setForeground(Color.black); 
		sex.setBackground(Color.white);
		email = new JTextField(); 
		email.setForeground(Color.black); 
		email.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);*/
		
		
		Del= new JButton("Delete");  
		Del.setToolTipText("To Add Item");
		home = new JButton("Home"); 
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(240,320,70,30);
		home.addActionListener(this);
		c.add(home);
		lid.setBounds(70,110,670,20);
		/*lname.setBounds(70,140,150,20);
		lsex.setBounds(70,170,150,20);
		lemail.setBounds(70,200,150,20);
		lpho.setBounds(70,220,150,20);*/
		
		id.setBounds(190,110,150,20);
		/*name.setBounds(190,140,150,20);
		sex.setBounds(190,170,150,20);
		email.setBounds(190,200,150,20);
		pho.setBounds(190,220,150,20);*/

		Del.setBounds(80,320,70,30);
		Del.addActionListener(this);

		c.add(lid);
                c.add(id);
		/*c.add(lname);
		c.add(lsex);	
		c.add(lemail);
		c.add(lpho);
		
		c.add(name);
		c.add(sex);
		c.add(email);
		c.add(pho);*/
		
		
		c.add(Del);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
		if(source==Del)
		{
			try{
        conn=MysqlConnect.ConnectDB();
         
        String Sql="DELETE FROM member WHERE mem_ID =?";
        pst =conn.prepareStatement(Sql);
       pst.setString(1,id.getText());
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
	public void n6()//public static void main(String arg[])
 	{
 	
	 }
}