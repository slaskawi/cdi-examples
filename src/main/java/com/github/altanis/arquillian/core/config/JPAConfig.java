package com.github.altanis.arquillian.core.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAConfig {

    @Produces
    @PersistenceContext(unitName = "default-pu")
    EntityManager entityManager;

}
