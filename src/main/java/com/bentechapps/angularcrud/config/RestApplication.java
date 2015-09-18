/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Daniel
 */
@ApplicationPath("rest")
public class RestApplication extends ResourceConfig {

    public RestApplication() {
        register(JacksonFeature.class);
        packages("com.bentechapps.angularcrud.rest");
    }

}
