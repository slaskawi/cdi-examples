package com.github.altanis.arquillian.core.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.github.altanis.arquillian.core.cdi.ProperItemsRepository;
import com.github.altanis.arquillian.core.items.ItemsRepository;
import com.github.altanis.arquillian.core.items.impl.JPAItemsRepository;

public class JPAConfig {

    @Produces
    @PersistenceContext(unitName = "default-pu")
    EntityManager entityManager;

    @Produces
    @ApplicationScoped
    @ProperItemsRepository
    public ItemsRepository createItemsRepository() {
        return new JPAItemsRepository("JPARepo", entityManager);
    }

}
