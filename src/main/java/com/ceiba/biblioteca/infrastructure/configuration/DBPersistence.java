package com.ceiba.biblioteca.infrastructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ceiba.biblioteca.infrastructure.repository.repo")
public class DBPersistence {
}
