/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camer
 */
public class BaseDAO {
    //jdbc:sqlserver://localhost:1433;databaseName=test;user=artlist;password=777; [artlist on Default schema]
    protected Connection connection;
    public BaseDAO()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = "jdbc:sqlserver://localhost:1433;databaseName=test;user=artlist;password=777; [artlist on Default schema]";
        
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
