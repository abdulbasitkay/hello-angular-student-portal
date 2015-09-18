/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebFilter(urlPatterns = "/rest/*")
public class ResponseCorsFilter implements Filter {


    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletResponse instanceof HttpServletResponse) {
            HttpServletResponse alteredResponse = ((HttpServletResponse) servletResponse);
            addHeadersFor200Response(alteredResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void addHeadersFor200Response(HttpServletResponse response) {
       response.addHeader("Access-Control-Allow-Origin", "*");
       response.addHeader("Access-Control-Allow-Methods", "*, Cache-Control, Pragma, Origin, Authorization, X-Requested-With, PUT, DELETE");
       response.addHeader("Access-Control-Allow-Headers", "*, Content-Type, GET, OPTIONS, X-XSRF-TOKEN");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}