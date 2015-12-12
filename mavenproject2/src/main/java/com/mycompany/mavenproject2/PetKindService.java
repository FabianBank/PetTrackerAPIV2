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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import model.Pet;
import model.PetKind;
import model.PetOwner;

/**
 *
 * @author Fabian
 */
@Path("/kind")
public class PetKindService extends BaseService {
    
    private Dao<PetKind, Integer> dao;
    
     public PetKindService() {
        try {
            dao = DaoManager.createDao(super.db, PetKind.class);
            
            if(!dao.isTableExists()) {
                TableUtils.createTable(db, PetKind.class); //Bag
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetKindService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @Path("/all")
    @GET
    public Response getPets() {
        List<PetKind> output = new ArrayList<>();
       
        try {
            output = dao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PetKindService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GenericEntity<List<PetKind>> entity = new GenericEntity<List<PetKind>>(output) {};
        return Response.status(200).entity(entity).build();
    }
    
    @Path("/delete")
    @DELETE
    public Response deletePetOwner(@HeaderParam("idpet") int id) {
        List<Pet> output = new ArrayList<>();
        Pet input = new Pet();
        input.setIdpet(id);
        
        try {
            dao.deleteById(input.getIdpet());
        } catch (SQLException ex) {
            Logger.getLogger(PetKindService.class.getName()).log(Level.SEVERE, null, ex);
        }

        GenericEntity<List<Pet>> entity = new GenericEntity<List<Pet>>(output) {
        };
        return Response.status(200).entity(entity).build();
    }
    
    @POST
    @Path("/create")
    public Response addPet(@HeaderParam("kind") String kind)
            throws SQLException {
        PetKind petKind = new PetKind();
        List<PetKind> pets = new ArrayList<>();
        
        petKind.setKind(kind);
        
        pets = dao.queryForAll();
//        System.out.println("PETOWNER->" + petOwners);
        //TODO Fix this!
        try {
                dao.create(petKind);
            } catch (SQLException ex) {
                Logger.getLogger(PetKindService.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        return Response.status(200).entity(true).build();
    }
    
}
