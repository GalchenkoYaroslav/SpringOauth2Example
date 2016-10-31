//package com.websystique.springmvc.configuration;
//
//import com.websystique.springmvc.service.UserService;
//import com.websystique.springmvc.service.Uservice;
//import com.websystique.springmvc.service.impl.UserviceImpl;
//import org.hibernate.SessionFactory;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by Yaroslav on 27.10.2016.
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory",
//        basePackages = {"com.websystique.springmvc.domain.permissions"})
//public class InformDatabaseConfig {
//
//    @Autowired
//    private Environment env;
//
//
//    @Bean
//    Uservice uservice(){
//        Uservice uservice = new UserviceImpl();
//        return uservice;
//    }
//
//     @Bean(name = "informFactoryBean")
//    public LocalSessionFactoryBean sessionFactoryBean() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.websystique.springmvc.domain.permissions");
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean (name = "informSessionFactory")
//    public SessionFactory sessionFactory() {
//        return sessionFactoryBean().getObject();
//    }
//
//
//
//    @Bean(name = "informDataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("datasource.url"));
//        dataSource.setUsername(env.getProperty("datasource.username"));
//        dataSource.setPassword(env.getProperty("datasource.password"));
//        return dataSource;
//    }
//
//
//    @Bean(name = "informEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("datasource.entitymanager.packages.to.scan"));
//        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
//        return entityManagerFactoryBean;
//    }
//
//    @Bean(name = "informTransactionManager")
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }
//
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", env.getRequiredProperty("datasource.dialect"));
//        properties.put("hibernate.show_sql", env.getRequiredProperty("datasource.show-sql"));
//        properties.put("hibernate.format_sql", env.getProperty("datasource.format-sql"));
//
//        return properties;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
//        return new HibernateTemplate(sessionFactory);
//    }
//}
