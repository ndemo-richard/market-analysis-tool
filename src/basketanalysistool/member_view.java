package basketanalysistool;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class member_view extends JFrame
{
    Container c;
    JTable table;
    JScrollPane pane;
    public member_view()
    {
        super("MEMBER_VIEW");
    c=getContentPane();
        Connection conn ;
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        conn=MysqlConnect.ConnectDB();
        String sql = "SELECT * FROM member_view";

        
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
        c.add(pane);
        setBounds(150,150,500,400);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        pack();
        setVisible(true);
    }

   public void n9()
          // public static void main(String[] args)
    {
       //member_view frame = new member_view();
        
    }
}