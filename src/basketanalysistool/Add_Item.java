package basketanalysistool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Add_Item extends JFrame implements ActionListener
{
    Connection conn = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
	JTextField id,name;
	Container c;
	JButton add,reset;
	JOptionPane jp = new JOptionPane();
	JLabel lid,lname;
        JPanel panel;
	int t=0;
	public Add_Item()
	{
		super("ADD Item");
		c = getContentPane();
		c.setLayout(null); 
		setBounds(500,300,450,420);
                c.setBackground(Color.GRAY);
                 panel = new JPanel();
                 panel.setLayout(null);
                panel.setBounds(20,20,400,300);
                panel.setBackground(Color.LIGHT_GRAY);
                
                lname = new JLabel("Name :");  
		lname.setForeground(Color.black);
		lid = new JLabel("Item ID :");  
		lid.setForeground(Color.black);
		
		
		name = new JTextField(); 
		name.setForeground(Color.black);
		name.setBackground(Color.white);
		id = new JTextField(); 
		id.setForeground(Color.black); 
		id.setBackground(Color.white);
		
		
		
		add = new JButton("Add"); 
		add.setToolTipText("To Add Item");
		reset = new JButton("Reset"); 
		reset.setToolTipText("To Reset Fields"); 

                lid.setBounds(70,120,670,20);
               lname.setBounds (70,150,150,20);
                
              
		id.setBounds(190,120,150,20);
                name.setBounds(190,150,150,20);
		
		
		add.setBounds(330,340,90,30);
		reset.setBounds(20,340,90,30);

		add.addActionListener(this);
		reset.addActionListener(this);
                
                panel.add(lid);
                panel.add(id);
                panel.add(lname);
                panel.add(name);
		c.add(add);
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
			try
			{
                            conn=MysqlConnect.ConnectDB();
			t=0;
            if(t==0)
            {
                    t=0;
                     pst  = conn.prepareStatement("insert into items values(?,?)");

                    if((id.getText()).length()!=0)
                    pst.setString(1,id.getText());
                    else
                    pst.setString(1,"");
                    if((name.getText()).length()!=0)
                    pst.setString(2,name.getText());



                    pst.executeUpdate();
                    jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESs",jp.INFORMATION_MESSAGE);
            }
            else
            {
                    jp.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",jp.ERROR_MESSAGE);
                    t=0;
            }

    }
    catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);}
 		}
		if(source==reset)
		{
			id.setEditable(true);
			name.setEditable(true);
			
			
			id.setText(null);
			name.setText(null);
			
			
		}
	}	
	public void n2()//public static void main(String arg[])
 	{
 		
		/*Add_Item u=new Add_Item();
		u.setResizable(false);
		u.setBounds(0,0,400,400);
		u.show();*/
	 }
}