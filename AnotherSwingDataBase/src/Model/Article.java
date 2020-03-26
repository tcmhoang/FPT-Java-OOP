/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;


/**
 *
 * @author Camer
 */
public class Article {

    private String ID, title;
    private Date date;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isValid()
    {
        return date != null && title != null && ID != null;
    }

    @Override
    public String toString() {
        return "Article{" + "ID=" + ID + ", title=" + title + ", date=" + date + '}';
    }
    
}
