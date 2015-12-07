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
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

            if (!dao.isTableExists()) {
                TableUtils.createTable(db, PetOwner.class); //Bag
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetOwnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Path("/all")
    @GET
    public Response getPetOwners() {
        List<PetOwner> output = new ArrayList<>();
        //TODO first 2 chapters off restfull java with JAX-XRS <- Study this for the exam.

        try {
            output = dao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }

        GenericEntity<List<PetOwner>> entity = new GenericEntity<List<PetOwner>>(output) {
        };
        return Response.status(200).entity(entity).build();
    }

    @Path("/login")
    @GET
    public Response getPetOwners(@HeaderParam("username") String name, @HeaderParam("password") String password) {
        List<PetOwner> output = new ArrayList<>();
        PetOwner input = new PetOwner();
        input.setUsername(name);
        input.setPassword(password);
        //TODO first 2 chapters off restfull java with JAX-XRS <- Study this for the exam.

        try {
            output = dao.queryForMatching(input);
        } catch (SQLException ex) {
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }

        GenericEntity<List<PetOwner>> entity = new GenericEntity<List<PetOwner>>(output) {
        };
        return Response.status(200).entity(entity).build();
    }

    @POST
    @Path("/create")
    public Response addPetOwner(@HeaderParam("username") String name, @HeaderParam("password") String password) throws SQLException {
        PetOwner owner = new PetOwner();
        List<PetOwner> petOwners = new ArrayList<>();
        owner.setUsername(name);
        owner.setPassword(password);
        petOwners = dao.queryForAll();
//        System.out.println("PETOWNER->" + petOwners);
        //TODO Fix this!
        if (owner.equals(petOwners)) {
            // 205 response = username allready excist in database
            return Response.status(403).entity(false).build();
        } else {

            try {
                dao.create(owner);
            } catch (SQLException ex) {
                Logger.getLogger(PetOwnerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Response.status(200).entity(true).build();
    }
    
    /**
     *  deletes a user by his/her id 
     */   
    @Path("/delete")
    @DELETE
    public Response deletePetOwner(@HeaderParam("idPetOwner") int id) {
        List<PetOwner> output = new ArrayList<>();
        PetOwner input = new PetOwner();
        input.setIdPetOwner(id);
        
        try {
            dao.deleteById(input.getIdPetOwner());
        } catch (SQLException ex) {
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }

        GenericEntity<List<PetOwner>> entity = new GenericEntity<List<PetOwner>>(output) {
        };
        return Response.status(200).entity(entity).build();
    }
    
    
}
