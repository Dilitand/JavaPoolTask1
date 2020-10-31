package ru.litvinov.javapool.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"ru.litvinov.javapool.model.dao","ru.litvinov.javapool.service"})
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class ConfigClass {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        StringBuilder url = new StringBuilder("jdbc:postgresql://");
        dataSource.setUrl(url
                //.append(environment.getProperty("url.localhostip")).append(":").append(environment.getProperty("url.port"))
                .append(environment.getProperty("url.containterip"))
                .append("/").append(environment.getProperty("url.database")).toString());
        dataSource.setUsername(environment.getProperty("postgres.username2"));
        dataSource.setPassword(environment.getProperty("postgres.password2"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("ru.litvinov.javapool.model.entity");
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL9Dialect");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory){
        final HibernateTransactionManager tr = new HibernateTransactionManager();
        tr.setDataSource(dataSource);
        tr.setSessionFactory(sessionFactory);
        return tr;
    }
}
