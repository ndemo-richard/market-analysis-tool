package basketanalysistool;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;


public class employee_view extends JFrame
{
    Container c;
    JTable table;
    JScrollPane pane;
    JPanel panel;
    public employee_view()
    {
        super("EMPLOYEE_VIEW");
    c=getContentPane();
    c.setLayout(null); 
		setBounds(500,300,720,420);
                c.setBackground(Color.GRAY);
        Connection conn ;
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        conn=MysqlConnect.ConnectDB();
        String sql = "SELECT * FROM employee_view";

        
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
         table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        pane = new JScrollPane( table );
        getContentPane().add( pane );
        pane.setBounds(10,100,670,100);
        panel=new JPanel();
        panel = new JPanel();
                 panel.setLayout(null);
                panel.setBounds(10,10,690,300);
                panel.setBackground(Color.LIGHT_GRAY);
                panel.add(pane);
        c.add(panel);
        setVisible(true);
    }

   public void n10()// public static void main(String[] args)
    {
      /*  employee_view frame = new employee_view();
        */
    }
}