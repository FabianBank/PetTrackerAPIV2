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
import model.PetOwner;

/**
 *
 * @author Fabian
 */
@Path("/pet")
public class PetService extends BaseService {
    
    private Dao<Pet, Integer> dao;
    
     public PetService() {
        try {
            dao = DaoManager.createDao(super.db, Pet.class);
            
            if(!dao.isTableExists()) {
                TableUtils.createTable(db, Pet.class); //Bag
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetOwnerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @Path("/all")
    @GET
    public Response getPets() {
        List<Pet> output = new ArrayList<>();
       
        try {
            output = dao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GenericEntity<List<Pet>> entity = new GenericEntity<List<Pet>>(output) {};
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
            Logger.getLogger(PetOwner.class.getName()).log(Level.SEVERE, null, ex);
        }

        GenericEntity<List<Pet>> entity = new GenericEntity<List<Pet>>(output) {
        };
        return Response.status(200).entity(entity).build();
    }
    
    @POST
    @Path("/create")
    public Response addPet(@HeaderParam("name") String name,
            @HeaderParam("color") String color,
            @HeaderParam("age") String age,
            @HeaderParam("type") String type,
            @HeaderParam("longitude") String longitude,
            @HeaderParam("latitude") String latitude,
            @HeaderParam("lost") int lost)
            throws SQLException {
        Pet pet = new Pet();
        List<Pet> pets = new ArrayList<>();
        
        pet.setName(name);
        pet.setColor(color);
        pet.setAge(age);
        pet.setType(type);
        pet.setLongitude(longitude);
        pet.setLatitude(latitude);
        pet.setLost(lost);
        
        
        pets = dao.queryForAll();
//        System.out.println("PETOWNER->" + petOwners);
        //TODO Fix this!
        try {
                dao.create(pet);
            } catch (SQLException ex) {
                Logger.getLogger(PetOwnerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        return Response.status(200).entity(true).build();
    }
    
}
