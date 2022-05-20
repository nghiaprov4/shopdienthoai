package com.se.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //Provides similar support to <mvc:annotation-driven /> in XML
@EnableTransactionManagement
@ComponentScan(basePackages = "com.se")
@PropertySource({"classpath:persistence-mssql.properties"})
public class AppConfig implements WebMvcConfigurer {
// define a bean for ViewResolver

    @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());
    // define a bean for ViewResolver

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource myDataSource() {
        // create connection pool
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
        // set the jdbc driver
        try {
            myDataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }
        // for sanity's sake, let's log url and user ... just to make sure we are reading the data
        logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
        // set database connection props
        myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        myDataSource.setUser(env.getProperty("jdbc.user"));
        myDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return myDataSource;
    }

    private Properties getHibernateProperties() {

        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.setProperty("hibernate.connection.CharSet", env.getProperty("hibernate.connection.CharSet"));
        props.setProperty("hibernate.connection.characterEncoding", env.getProperty("hibernate.connection.characterEncoding"));
        props.setProperty("hibernate.connection.useUnicode", env.getProperty("hibernate.connection.useUnicode"));
        return props;
    }
    
//    @Bean
//    public DataSource securityDataSource() {
//
//        // create connection pool
//        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
//        // set the jdbc driver class
//        try {
//                securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
//        } catch (PropertyVetoException exc) {
//                throw new RuntimeException(exc);
//        }
//        // log the connection props
//        // for sanity's sake, log this info
//        // just to make sure we are REALLY reading data from properties file
//
//        logger.info(">>> security.jdbc.url=" + env.getProperty("security.jdbc.url"));
//        logger.info(">>> security.jdbc.user=" + env.getProperty("security.jdbc.user"));
//        // set database connection props
//        securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
//        securityDataSource.setUser(env.getProperty("security.jdbc.user"));
//        securityDataSource.setPassword(env.getProperty("security.jdbc.password"));
//        // set connection pool props
//        securityDataSource.setInitialPoolSize(
//                        getIntProperty("security.connection.pool.initialPoolSize"));
//
//        securityDataSource.setMinPoolSize(
//                        getIntProperty("security.connection.pool.minPoolSize"));
//
//        securityDataSource.setMaxPoolSize(
//                        getIntProperty("security.connection.pool.maxPoolSize"));
//
//        securityDataSource.setMaxIdleTime(
//                        getIntProperty("security.connection.pool.maxIdleTime"));
//
//        return securityDataSource;
//    }
    

    private int getIntProperty(String propName) {

        String propVal = env.getProperty(propName);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }
    
    
    

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        // create session factorys
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }
    
    
    

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipart = new CommonsMultipartResolver();
        multipart.setMaxUploadSize(3 * 1024 * 1024);
        return multipart;
    }

    @Bean
    public MultipartFilter multipartFilter() {
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("multipartResolver");
        return multipartFilter;
    }

//    @Bean
//    public FilterRegistration filterRegistration(ServletContext servletContext) {
//        FilterRegistration.Dynamic filterRegistration
//                = servletContext.addFilter("endcoding-filter", new CharacterEncodingFilter());
//        filterRegistration.setInitParameter("encoding", "UTF-8");
//        filterRegistration.setInitParameter("forceEncoding", "true");
//
//        //make sure encodingFilter is matched most first, by "false" arg
//        filterRegistration.addMappingForUrlPatterns(null, false, "/*");
//        return filterRegistration;
//    }

//    @Bean
//    public CharacterEncodingFilter characterEncodingFilter(ServletContext servletContext){
//        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class); 
//        fr.setInitParameter("encoding", "UTF-8");
//        fr.setInitParameter("forceEncoding", "true");
//        fr.addMappingForUrlPatterns(null, true, "/*");   
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setForceEncoding(true);
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceRequestEncoding(true);
//        characterEncodingFilter.setForceRequestEncoding(true);
//        return characterEncodingFilter;
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

}
