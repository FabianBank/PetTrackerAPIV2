/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;




import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ruud
 */


  
@Path("/hello")
public class Test {
  
    @GET
    public Response getMsg(@PathParam("param") String message) {
        String output = "Hello , is it me your looking for?";
        return Response.status(200).entity(output).build();
    }
}

