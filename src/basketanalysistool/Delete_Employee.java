package basketanalysistool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPopupMenu;
public class Delete_Employee extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
	JTextField id,name,dob,qual,job,sex,pho;
	Container c;
	JButton Del,home;
	int t=0;
        int flag=0;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname,ldob,lqual,ljob,lsex,lpho;
	public Delete_Employee()
	{
            super("Delete Empolyee");
		c = getContentPane();
		c.setLayout(null); 
		setBounds(150,150,400,400);
		lid = new JLabel("* ID :");  
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		ldob = new JLabel("Date Of Birth :");  
		ldob.setForeground(Color.black);
		lqual = new JLabel("Qualification :");  
		lqual.setForeground(Color.black);
		ljob = new JLabel("Job :");  
		ljob.setForeground(Color.black);
		lsex = new JLabel("Gender :");  
		lsex.setForeground(Color.black);
		lpho = new JLabel("Phone Number :");  
		lpho.setForeground(Color.black);
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		dob = new JTextField(); 
		dob.setForeground(Color.black); 
		dob.setBackground(Color.white);
		qual = new JTextField(); 
		qual.setForeground(Color.black); 
		qual.setBackground(Color.white);
		job = new JTextField(); 
		job.setForeground(Color.black); 
		job.setBackground(Color.white);
		sex = new JTextField(); 
		sex.setForeground(Color.black); 
		sex.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);
		
		
		Del = new JButton("DELETE");  
		Del.setToolTipText("To Delete Item");
		home = new JButton("Home"); 
        	home.setToolTipText("Goto Home Page");
        	home.setBounds(240,320,70,30);
		home.addActionListener(this);
		c.add(home);
		lid.setBounds(70,110,670,20);
		lname.setBounds(70,140,150,20);
		ldob.setBounds(70,170,150,20);
		lqual.setBounds(70,200,150,20);
		ljob.setBounds(70,230,150,20);
		lsex.setBounds(70,260,150,20);
		lpho.setBounds(70,290,150,20);
		
		id.setBounds(190,110,150,20);
		name.setBounds(190,140,150,20);
		dob.setBounds(190,170,150,20);
		qual.setBounds(190,200,150,20);
		job.setBounds(190,230,150,20);
		sex.setBounds(190,260,150,20);
		pho.setBounds(190,290,150,20);

		Del.setBounds(80,320,70,30);
		

		Del.addActionListener(this);
		

		c.add(lid);
		/*c.add(lname);
		c.add(ldob);	
		c.add(lqual);
		c.add(ljob);
		c.add(lsex);
		c.add(lpho);*/
		c.add(id);
		/*c.add(name);
		c.add(dob);
		c.add(qual);
		c.add(job);
		c.add(sex);
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
         
        String Sql="DELETE FROM employee WHERE id =?";
        pst =conn.prepareStatement(Sql);
       pst.setString(1,id.getText());
       pst.executeUpdate();
       pst.setInt(1,1);
       jp.showMessageDialog(this,"Record Deleted sucessfuly","DELETED",jp.INFORMATION_MESSAGE);
					flag=1;
       //exctract the rest of the data
     /*  ResultSet rs= pst.executeQuery("SELECT emp_name,dob,qualification,job,emp_sex,phone");
       while (rs.next()){
       String id=rs.getString("id");
       String name=rs.getString("emp_name");
       String dob=rs.getString("dob");
       String qual=rs.getString("qualification");
       String job=rs.getString("job");
       String sex=rs.getString("emp_sex");
       String pho=rs.getString("phone");
      // JTextField.setText(id);
      rs.getString(id);
      rs.getString(name);
      rs.getString(dob);
      rs.getString(qual);
      rs.getString(job);
      rs.getString(sex);
      rs.getString(pho);
       }*/
       }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}
 		}
		if(source==home)
		{
                        this.dispose();
		}
	}	
	public void n4()//public static void main(String arg[])
 	{

	 }
}