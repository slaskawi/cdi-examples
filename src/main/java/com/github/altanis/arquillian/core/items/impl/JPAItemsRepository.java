package com.github.altanis.arquillian.core.items.impl;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.github.altanis.arquillian.core.cdi.ProperItemsRepository;
import com.github.altanis.arquillian.core.items.Item;
import com.github.altanis.arquillian.core.items.ItemsRepository;

@ApplicationScoped
@ProperItemsRepository
public class JPAItemsRepository implements ItemsRepository {

    @Inject
    private EntityManager em;

    @Override
    public void addItem(Item item) {
        em.persist(item);
    }

    @Override
    public Collection<Item> getAllItems() {
        return em.createQuery("SELECT i from Item i", Item.class).getResultList();
    }
}
