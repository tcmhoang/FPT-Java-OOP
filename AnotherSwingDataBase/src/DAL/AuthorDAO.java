/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Author;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camer
 */
public class AuthorDAO extends BaseDAO {

    public void upload(Author a, String id) {
        try {
            String sql = "INSERT INTO [Author]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[institution]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[aid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, a.getID());
            stm.setString(2, a.getName());
            stm.setString(3, a.getInstituton());
            stm.setString(4, a.getGender());
            stm.setDate(5, a.getDob());
            stm.setString(6, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
