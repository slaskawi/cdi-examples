package com.github.altanis.arquillian.core.items.impl;

import java.util.Collection;
import javax.persistence.EntityManager;
import com.github.altanis.arquillian.core.items.Item;
import com.github.altanis.arquillian.core.items.ItemsRepository;

public class JPAItemsRepository implements ItemsRepository {

    private EntityManager em;

    private String repositoryName;

    public JPAItemsRepository(String repositoryName, EntityManager em) {
        this.repositoryName = repositoryName;
        this.em = em;
    }

    @Override
    public void addItem(Item item) {
        em.persist(item);
    }

    @Override
    public Collection<Item> getAllItems() {
        return em.createQuery("SELECT i from Item i", Item.class).getResultList();
    }
}
