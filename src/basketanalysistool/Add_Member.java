package basketanalysistool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPopupMenu;
public class Add_Member extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
	JTextField id,name,email,pho;
	Container c;
	JButton add,reset,home;
	int t=0,flag=0;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname,lsex,lemail,lpho;
         JPanel panel;
         JRadioButton male,female;
                    ButtonGroup bg;
                    String gender="";
	public Add_Member()
	{
            super("ADD Member");
		c = getContentPane();
		c.setLayout(null); 
		setBounds(500,300,450,420);
                c.setBackground(Color.GRAY);
                panel = new JPanel();
                 panel.setLayout(null);
                panel.setBounds(20,20,400,300);
                panel.setBackground(Color.LIGHT_GRAY);
		lid = new JLabel("Member ID");
		lid.setForeground(Color.black);
		lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		lsex = new JLabel("Gender :");  
		lsex.setForeground(Color.black);
		lemail = new JLabel("Email:");  
		lemail.setForeground(Color.black);
		lpho = new JLabel("Phone Number :");  
		lpho.setForeground(Color.black);
		
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
                                            male = new JRadioButton("MALE"); 
		female=new JRadioButton("FEMALE");
		email = new JTextField(); 
		email.setForeground(Color.black); 
		email.setBackground(Color.white);
		pho = new JTextField(); 
		pho.setForeground(Color.black); 
		pho.setBackground(Color.white);
		
		
		add = new JButton("ADD");  
		add.setToolTipText("To Add Item");
		reset = new JButton("Reset"); 
		reset.setToolTipText("To Reset Fields");
		lid.setBounds(20,20,670,20);
		lname.setBounds(20,50,150,20);
                                            lsex.setBounds(20,80,150,20);
		lemail.setBounds(20,110,150,20);
		lpho.setBounds(20,140,150,20);
		
		id.setBounds(190,20,150,20);
		name.setBounds(190,50,150,20);
                                           male.setBounds(190,80,70,20);
                                        male.setBackground(Color.LIGHT_GRAY);
                                           female.setBounds(260,80, 150,20);
                                           female.setBackground(Color.LIGHT_GRAY);
		email.setBounds(190,110,150,20);
		pho.setBounds(190,140,150,20);

		add.setBounds(330,340,90,30);
		reset.setBounds(20,340,90,30);

		add.addActionListener(this);
		reset.addActionListener(this);
                
                                            bg=new ButtonGroup();
                                            bg.add(male);
                                            bg.add(female);

		panel.add(lid);
		panel.add(lname);
		panel.add(lsex);	
		panel.add(lemail);
		panel.add(lpho);
		panel.add(id);
		panel.add(name);
		panel.add(email);
		panel.add(pho);
                                            panel.add(male);
                                           panel.add(female);
		
		c.add(panel);
		c.add(add);
		c.add(reset);
		
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
			t=0;
			if(pho.getText().length()!=10)
			jp.showMessageDialog(this,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
			else
			{
				
				if(t==0)
				{
					t=0;
					PreparedStatement ps  = conn.prepareStatement("insert into member values(?,?,?,?,?)");
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
                                                                                                            if(male.isSelected())
                                                                                                                gender="male";
                                                                                                                        else if(female.isSelected())
                                                                                                                            gender="female";
					ps.setString(3,gender);
					//else
					//ps.setString(3,"");
					if((email.getText()).length()!=0)
					ps.setString(4,email.getText());
					else
					ps.setString(4,"");
					if((pho.getText()).length()!=0)
					ps.setString(5,pho.getText());
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
			catch(Exception e)
			{
				System.out.println(e);
                        }
 		}
		if(source==reset)
		{
			id.setEditable(true);
			name.setEditable(true);
			//sex.setEditable(true);
			email.setEditable(true);
			pho.setEditable(true);

			id.setText(null);
			name.setText(null);
			//sex.setText(null);
			email.setText(null);
			pho.setText(null);
		}
		if(source==home)
		{
                        this.dispose();
		}
	}	
	public void n3()//public static void main(String arg[])
 	{
 		
		/*Add_Employee u=new Add_Employee();
		u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}