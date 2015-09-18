/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Daniel
 */
@Path("/hello")
public class HelloRest {
    
    @GET()
    public Response hello() {
        return Response.ok("hello", MediaType.TEXT_PLAIN).build();
    }
} 
