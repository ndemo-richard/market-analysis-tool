package basketanalysistool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.DISPOSE_ON_CLOSE;
import javax.swing.JPopupMenu;
public class Add_Employee extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
	JTextField id,name,dob,qual,job,pho;
	Container c;
	JButton add,reset;
	int t=0,flag=0;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname,ldob,lqual,ljob,lsex,lpho;
                    JPanel panel;
                    JRadioButton male,female;
                    ButtonGroup bg;
                    String gender="";
	public Add_Employee()
	{
            super("ADD Empolyee");
       
		c = getContentPane();
		c.setLayout(null); 
		setBounds(500,300,450,420);
                c.setBackground(Color.GRAY);
                 panel = new JPanel();
                 panel.setLayout(null);
                panel.setBounds(20,20,400,300);
                panel.setBackground(Color.LIGHT_GRAY);
		lid = new JLabel("Employee ID :");  
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
		male = new JRadioButton("MALE"); 
		female=new JRadioButton("FEMALE");
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);
	
		reset = new JButton("Reset"); 
		add = new JButton("Add"); 
        	add.setBounds(330,340,90,30);
		add.addActionListener(this);
		c.add(add);
		lid.setBounds(20,20,670,20);
		lname.setBounds(20,50,150,20);
		ldob.setBounds(20,80,150,20);
		lqual.setBounds(20,110,150,20);
		ljob.setBounds(20,140,150,20);
		lsex.setBounds(20,170,150,20);
		lpho.setBounds(20,210,150,20);
		
		id.setBounds(190,20,150,20);
		name.setBounds(190,50,150,20);
		dob.setBounds(190,80,150,20);
		qual.setBounds(190,110,150,20);
		job.setBounds(190,140,150,20);
		male.setBounds(190,170,70,20);
               male.setBackground(Color.LIGHT_GRAY);
         //      male.addActionListener(this);
                                           female.setBounds(260,170,150,20);
                                           female.setBackground(Color.LIGHT_GRAY);
                                         //  female.addActionListener(this);
		pho.setBounds(190,210,150,20);
		reset.setBounds(20,340,90,30);
		reset.addActionListener(this);
                               bg=new ButtonGroup();
                               bg.add(male);
                                bg.add(female);
                                
                                
                           

		panel.add(lid);
		panel.add(lname);
		panel.add(ldob);	
		panel.add(lqual);
		panel.add(ljob);
		panel.add(lsex);
		panel.add(lpho);
		panel.add(id);
		panel.add(name);
		panel.add(dob);
		panel.add(qual);
		panel.add(job);
		panel.add(male);
                                           panel.add(female);
		panel.add(pho);
                                           
	c.add(reset);
                c.add(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
        }
        
	public void actionPerformed(ActionEvent ae)
	{	
            
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
                 
             
		if(source==add)
		{
			flag=0;
			try
			{
                              conn=MysqlConnect.ConnectDB();
                            		if(source==add)

                             
			t=0;
			if(pho.getText().length()!=10)
			jp.showMessageDialog(this,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
			else
				if(t==0)
				{
					t=0;
					PreparedStatement ps  = conn.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
					if((dob.getText()).length()!=0)
					ps.setString(3,dob.getText());
					else
					ps.setString(3,"");
					if((qual.getText()).length()!=0)
					ps.setString(4,qual.getText());
					else
					ps.setString(4,"");
					if((job.getText()).length()!=0)
					ps.setString(5,job.getText());
					else
					ps.setString(5,"");
					if(male.isSelected())
                                                                                                                gender="male";
                                                                                                                        else if(female.isSelected())
                                                                                                                            gender="female";
					ps.setString(6,gender);
					if((pho.getText()).length()!=0)
					ps.setString(7,pho.getText());
					else
					ps.setString(7,"");
					
					ps.executeUpdate();
					JOptionPane.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
					flag=1;
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",JOptionPane.ERROR_MESSAGE);
					t=0;
				}
				conn.close();
			}
			catch(HeadlessException | SQLException e)
			{
				System.out.println(e);
                        }
 		}
		if(source==reset)
		{
			id.setEditable(true);
			name.setEditable(true);
			dob.setEditable(true);
			qual.setEditable(true);
			job.setEditable(true);
			//sex.setEditable(true);
			pho.setEditable(true);

			id.setText(null);
			name.setText(null);
			dob.setText(null);
			qual.setText(null);
			pho.setText(null);
		}
	}	
	public void n1()//public static void main(String arg[])
 	{
 		
		/*Add_Employee u=new Add_Employee();
		u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}