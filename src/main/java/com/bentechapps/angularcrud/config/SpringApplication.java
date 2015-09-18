/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bentechapps.angularcrud.config;

import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Daniel
 */
@Log4j
@Configuration
@ComponentScan(basePackages = {"com.bentechapps.angularcrud.rest",
    "com.bentechapps.angularcrud.config",
    "com.bentechapps.angularcrud.service",
    "com.bentechapps.angularcrud.dao"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:/appcontext/application.properties"})
public class SpringApplication {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.bentechapps.angularcrud.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setNamingStrategy(new ImprovedNamingStrategy());
        return sessionFactory;
    }

    @PostConstruct
    public void init() {
        log.info("ApplicationConfiguration initialized.");
    }

    public DataSource dataSource() {
        BasicDataSource dataSource;

        dataSource = (BasicDataSource) localDataSource();

        return dataSource;
    }

    private DataSource localDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        hibernateProperties.setProperty("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

        hibernateProperties.setProperty("c3p0.min_size", "5");
        hibernateProperties.setProperty("c3p0.max_size", "20");
        hibernateProperties.setProperty("c3p0.timeout", "100");
        hibernateProperties.setProperty("hibernate.c3p0.acquire_increment", "1");
        hibernateProperties.setProperty("c3p0.max_statements", "10");
        return hibernateProperties;
    }
}
