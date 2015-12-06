/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject2;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import model.PetOwner;

/**
 *
 * @author Fabian
 */
@Path("/petowner")
public class PetOwnerService extends BaseService {
    
    private Dao<PetOwner, Integer> dao;
    
    public PetOwnerService() {
        try {
            dao = DaoManager.createDao(super.db, PetOwner.class);
            
            if(!dao.isTableExists()) {
                TableUtils.createTable(db, PetOwner.class); //Bag
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetOwnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @GET
    public Response getPetOwners() {
        List<PetOwner> output = new ArrayList<>();
       
        try {
            output = dao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GenericEntity<List<PetOwner>> entity = new GenericEntity<List<PetOwner>>(output) {};
        return Response.status(200).entity(entity).build();
    }
}

