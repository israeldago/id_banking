package com.israeldago.idBanking.backend.dao.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@ConditionalOnMissingBean(type = "DataSource")
public class DaoConfig {

    @Autowired
    private Environment env;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaProperties(daoHibernateProps());
        emfb.setPersistenceUnitName("id_banking_dao_PU");
        emfb.setPackagesToScan("com.israeldago.idBanking.backend.domain.entities");
        emfb.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        return emfb;
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    HikariDataSource dataSource() {
        return dataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    Properties daoHibernateProps(){
        Properties hibernateProps = new Properties();
        hibernateProps.setProperty("hibernate.hbm2ddl.auto", env.getProperty("sql.hibernate.ddl-auto"));
        hibernateProps.setProperty("hibernate.dialect", env.getProperty("sql.hibernate.dialect"));
        hibernateProps.setProperty("hibernate.show-sql", env.getProperty("sql.hibernate.show-sql"));
        return hibernateProps;
    }

    @Bean
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(Boolean.getBoolean(daoHibernateProps().getProperty("hibernate.show-sql")));
        jpaVendorAdapter.setDatabasePlatform(MySQL5Dialect.class.getName());
        return jpaVendorAdapter;
    }

    @Bean
    @ConditionalOnMissingBean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
