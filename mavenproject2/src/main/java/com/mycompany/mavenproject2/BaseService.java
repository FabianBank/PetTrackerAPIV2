/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject2;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PetOwner;

/**
 *
 * @author Fabian
 */
public class BaseService {
    
    protected ConnectionSource db;
    
    public BaseService() {
        String mysql_url    = "jdbc:mysql://localhost:3306/zsteurp001";
        String mysql_user   = "root";
        String mysql_pass   = "p@vilion21";
        
        try {
            this.db = new JdbcConnectionSource(mysql_url, mysql_user, mysql_pass);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final void createTables() throws SQLException {
        TableUtils.createTable(db, PetOwner.class); //PetOwner
    }
    
    public final void closeConnection() throws SQLException {
        db.close();
    }
}

