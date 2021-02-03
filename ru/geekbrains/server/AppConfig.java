package ru.geekbrains.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.geekbrains.server")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/network_chat?serverTimezone=UTC", "root", "02051986");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }
}
