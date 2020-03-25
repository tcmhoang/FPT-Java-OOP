/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Article;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camer
 */
public class ArticleDAO extends BaseDAO {

    public void upload(Article article) {
        try {
            String sql = "INSERT INTO [Article]\n"
                    + "           ([id]\n"
                    + "           ,[title]\n"
                    + "           ,[Date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, article.getID());
            stm.setString(2, article.getTitle());
            stm.setDate(3, article.getDate());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
