package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;
import com.sda.javagda40.UltraGuitartron3000.scales.CountingScales;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:db-data/mydatabase");
        configuration.setProperty("hibernate.connection.username", "admin123");
        configuration.setProperty("hibernate.connection.password", "admin123");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//          MYSQL
//        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/musicdb?serverTimezone=Europe/Warsaw&createDatabaseIfNotExist=true");
//        configuration.setProperty("hibernate.connection.username", "root");
//        configuration.setProperty("hibernate.connection.password", "root");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(Chords.class);
        configuration.addAnnotatedClass(Scales.class);
        configuration.addAnnotatedClass(CountingChords.class);
        configuration.addAnnotatedClass(CountingScales.class);
        configuration.addAnnotatedClass(Trainee.class);

        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}