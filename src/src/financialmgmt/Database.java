/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package financialmgmt;

import java.sql.*;

/**
 *
 * @author smrithi
 */
public class Database {
        public static Connection getCon() throws SQLException {
            return DriverManager.getConnection("jdbc:odbc:finance");
        }
    private Connection con;
        
        public Statement createStatement() throws SQLException {
            return this.con.createStatement();
        }
        public Database() throws SQLException {
            this.con = DriverManager.getConnection("jdbc:odbc:finance");
        }
        
        public static int getCount(String tablename) throws SQLException
        {
            String str = "SELECT * FROM " + tablename;
            Connection conn = Database.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(str);
            int count = 0;
            while(rs.next())
                count++;
            conn.close();
            return count;
        }
}
