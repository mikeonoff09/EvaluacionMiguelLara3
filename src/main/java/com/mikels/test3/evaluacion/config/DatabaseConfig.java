package com.mikels.test3.evaluacion.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.mikels.test3.evaluacion.repository")
@EnableTransactionManagement
public class DatabaseConfig {
    // Configuraciones adicionales relacionadas con la base de datos
}
