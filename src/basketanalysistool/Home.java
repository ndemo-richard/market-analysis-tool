
package basketanalysistool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;
public class Home extends JFrame implements ActionListener{
    JLabel name ,user,title;
    public JLabel display,name2,logo,logo2;
     JMenuBar menubar;
     JPanel bar,hold,home;
     JButton addemployee,additem,addtransaction,frequentitem,searchmember,addmember;
     JMenu Fitems,emp,mem,help,items,trans,Reports;
     JMenuItem aemp,amem,dmem,vmem,aitems,atrans,demp,ditems,vemp,vitems,vtrans,vfitems,frequentitems;
   Container c;
    public Timer clock;
  public int secs = 00;
  public int mins = 00;
  public int hrs =00;
   private DecimalFormat dFormat = new DecimalFormat("00");
    public Home() {
         super("-");
      c = getContentPane();
      c.setBackground(Color.GRAY);
        c.setLayout(null);
       setBounds(20,20,1300,720);
       

        menubar = new JMenuBar();
        menubar.setBackground(new Color(204, 204, 255));
        menubar.setFont(new java.awt.Font("Segoe UI", 1, 19));
        menubar.setBounds(00,00,1300,30);
        emp = new  JMenu();
        emp.setBackground(new Color(102,255,204));
        emp.setText("EMPLOYEE");
        mem=new JMenu();
        mem.setBackground(new Color(102,255,204));
        mem.setText("MEMBER");
        items = new JMenu();
          items.setBackground(new Color(102,255,204));
        items.setText("ITEMS");
         trans = new  JMenu("TRANSACTION");
          Fitems = new JMenu();
          Fitems.setText("FREQUENT ITEM");
          Reports = new JMenu();
          Reports.setBackground(new Color(102,255,204));
            Reports.setText("REPORTS");
          help = new JMenu();
          help.setText("Help");
          
          bar =new JPanel();
          bar.setBackground(Color.ORANGE);
          bar.setLayout(null);
         bar.setBounds(00,130,1300,20);
         
         hold =new JPanel();
          hold.setBackground(Color.YELLOW);
          hold.setLayout(null);
         hold.setBounds(00,150,1300,30);
         hold.add(menubar);
         
         home=new JPanel();
         home.setBackground(Color.GRAY);
         home.setLayout(null);
       home.setBounds(00,170,1300,515);
       
       addemployee=new JButton("ADD EMPLOYEE");
       addemployee.setBackground(Color.CYAN);
       addemployee.setBounds(150,110,200,50);
       home.add(addemployee);
       addemployee.addActionListener(this);
       
       additem=new JButton("ADD ITEM");
       additem.setBackground(Color.CYAN);
       additem.setBounds(150,210,200,50);
     additem.addActionListener(this);
       home.add(additem);
       
       addmember=new JButton("ADD MEMBER");
       addmember.setBackground(Color.CYAN);
       addmember.setBounds(150,310,200,50);
    addmember.addActionListener(this);
       home.add(addmember);
       
       searchmember=new JButton("SEARCH MEMBER");
       searchmember.setBackground(Color.CYAN);
       searchmember.setBounds(750,110,200,50);
       searchmember.addActionListener(this);
       home.add(searchmember);
       
       addtransaction=new JButton("ADD TRANSACTION");
       addtransaction.setBackground(Color.CYAN);
       addtransaction.setBounds(750,210,200,50);
       addtransaction.addActionListener(this);
       home.add(addtransaction);
       
       frequentitem=new JButton("FREQUENT ITEM");
       frequentitem.setBackground(Color.CYAN);
       frequentitem.setBounds(750,310,200,50);
      frequentitem.addActionListener(this);
       home.add(frequentitem);
       
       
         
         
         try{
         BufferedImage mypic=ImageIO.read(this.getClass().getResource("snow.png"));
         JLabel piclabel=new JLabel(new ImageIcon(mypic));
         piclabel.setLayout(null);
         piclabel.setBounds(370,10,500,40);
        c.add(piclabel);
         
         }catch (IOException ex){
         }
         
         try{
         BufferedImage mypic2=ImageIO.read(this.getClass().getResource("market2.jpeg"));
         logo=new JLabel(new ImageIcon(mypic2));
         logo.setLayout(null);
         logo.setBounds(05,05,120,120);
        c.add(logo);
         
         }catch (IOException ex){
         }
         try{
         BufferedImage mypic3=ImageIO.read(this.getClass().getResource("basket.jpeg"));
         logo2=new JLabel(new ImageIcon(mypic3));
         logo2.setLayout(null);
         logo2.setBounds(1130,05,160,120);
        c.add(logo2);
         
         }catch (IOException ex){
         }
         
          name2=new JLabel();
  name2.setBounds(200,00,40,20);
  name2.setFont(new java.awt.Font("Dialog", 1, 12));
  name2.setForeground(Color.BLACK);
  display = new JLabel();
    display.setBounds(240,00,100,20);
    display.setFont(new java.awt.Font("Dialog", 1, 12));
    display.setForeground(Color.black);
     bar.add(name2);
   bar.add(display);
    
    clock = new Timer(1000, this);
   clock.start();
         
         user = new JLabel("Username: ");
         user.setBackground(new Color(31,190,214));
         user.setFont(new java.awt.Font("Dialog", 1, 12));
          user.setBounds(20,00,100,20);
         
          name = new JLabel();
          name.setBackground(new Color(31,190,214));
          name.setBounds(100,00,100,20);
    
          
        aemp = new JMenuItem("Add Employee");
        aemp.addActionListener(this);
        emp.add(aemp);
        demp = new JMenuItem("Delete Employee");
        demp.addActionListener(this);
        emp.add(demp);
        vemp = new JMenuItem("View Employee");
        vemp.addActionListener(this);
        emp.add(vemp);
        amem=new JMenuItem("Add Member");
        amem.addActionListener(this);
        mem.add(amem);
        dmem=new JMenuItem("Delete Member");
        dmem.addActionListener(this);
        mem.add(dmem);
        vmem=new JMenuItem("View Member");
        vmem.addActionListener(this);
        mem.add(vmem);
        aitems = new JMenuItem("Add Item");
        aitems.addActionListener(this);
        items.add(aitems);
        ditems = new JMenuItem("Delete Item");
        ditems.addActionListener(this);
        items.add(ditems);
        vitems = new JMenuItem("View Items");
        vitems.addActionListener(this);
        items.add(vitems);
        atrans = new JMenuItem("Add Transaction");
        atrans.addActionListener(this);
        trans.add(atrans);
        vtrans = new JMenuItem("View Transaction");
        vtrans.addActionListener(this);
       trans.add(vtrans);
        vfitems =new JMenuItem("FrequentItem analysis");
        Fitems.add(vfitems);
        vfitems.addActionListener(this);
        frequentitems =new JMenuItem("Analysis report");
       Reports.add(frequentitems);
        frequentitems.addActionListener(this);
       
        menubar.add(emp);
        menubar.add(mem);
        menubar.add(items);
        menubar.add(trans);
        menubar.add(Fitems);
        menubar.add(Reports);
        menubar.add(help);
        c.add(hold);
        c.add(bar);
        bar.add(user);
        bar.add(name);
       c.add(home);
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
    }                       
public void actionPerformed(ActionEvent ae)
	{	
		String str1=(String)ae.getActionCommand();
		Object source = ae.getSource();
                
                if (source==aemp){
              
                Add_Employee u1=new Add_Employee();
                u1.n1();
                 // this.dispose();
                }
                if (source==demp){
                Delete_Employee u1=new Delete_Employee();
                u1.n4();
                }
                if (source==amem){
                Add_Member u2=new Add_Member();
                u2.n3();
                }
                if (source==dmem){
                Delete_Member u2=new Delete_Member();
                u2.n6();
                }
                if (source==aitems){
                Add_Item u2=new Add_Item();
                u2.n2();
                }
                if (source==ditems){
                Delete_Item u2=new Delete_Item();
                u2.n5();
                }
                if (source==atrans){
                Add_transaction u2=new Add_transaction();
                u2.n7();
                }
               if (source==vfitems){
                Frequentitem u2=new Frequentitem();
                u2.n8();
                }
               if (source==vmem){
               member_view u2=new member_view();
                u2.n9();
                }
               if (source==vemp){
                employee_view u2=new employee_view();
                u2.n10();
                }
               if (source==vitems){
                item_view u2=new item_view();
                u2.n11();
                }
               
            if (source==addemployee){
                Add_Employee u1=new Add_Employee();
                u1.n1();
                }
           if (source==additem){
               Add_Item u2=new Add_Item();
                u2.n2();
                }
            if (source==addmember){
                Add_Member u2=new Add_Member();
                u2.n3();
                }
        //    if (source==searchmember){
            //    Add_Employee u1=new Add_Employee();
          //      u1.n1();
           //     }
           if (source==addtransaction){
                Add_transaction u2=new Add_transaction();
                u2.n7();
                }
if (source==frequentitem){
               Frequentitem u2=new Frequentitem();
                u2.n8();
}
          
               if (ae.getSource() == clock)
    {
      secs++;
    }
 
    if (secs == 60)
    {
      mins++;
      secs = 00;
    }
 
    if (mins == 60)
    {
      hrs++;
      mins = 00;
      secs = 00;
    }
 
    if (hrs == 24)
    {
      hrs = 00;
      mins = 00;
      secs = 00;
    }
    name2.setText("Time:");
    display.setText( dFormat.format(hrs) + ":" + dFormat.format(mins) + ":" +  dFormat.format(secs));
    
        }
    public void nn () {
 
                Home u=new Home();
            }
    
    }

    
    
    
                       

