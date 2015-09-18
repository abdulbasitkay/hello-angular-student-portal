/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.config;

import javax.annotation.Priority;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 *
 * @author Daniel
 */
@Priority(value = 1)
public class SpringApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Tell jersey-spring3 the context is already initialized

        servletContext.setInitParameter("contextConfigLocation", "NOTNULL");
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(SpringApplication.class);
        servletContext.addListener(new ContextLoaderListener(appContext));
    }

}
