package com.asgard.consumer.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.asgard.consumer.odoo.model.ResPartner;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.asgard.consumer.odoo.repository",
		entityManagerFactoryRef ="clientEntityManagerFactory",
		transactionManagerRef = "clientTransactionManager")
public class odooconfig {

    @Bean
    @ConfigurationProperties("spring.datasource.odoo")
    public DataSourceProperties clientDataSourceProperties() {
        return new DataSourceProperties();
    }

        @Bean
    @ConfigurationProperties("spring.datasource.odoo.configuration")
    public DataSource clientDataSource() {
        return clientDataSourceProperties().initializeDataSourceBuilder()
                .type( HikariDataSource.class).build();
    }
        @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
       return new EntityManagerFactoryBuilder(vendorAdapter, new HashMap<>(), null);
    }

        @Bean(name = "clientEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean clientEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(clientDataSource())
                .packages( ResPartner.class)
                .build();
    }
        @Bean(name = "clientTransactionManager")
    public PlatformTransactionManager clientTransactionManager(
            final @Qualifier("clientEntityManagerFactory") 
			LocalContainerEntityManagerFactoryBean clientEntityManagerFactory) {
        return new JpaTransactionManager(clientEntityManagerFactory.getObject());
    }


}
