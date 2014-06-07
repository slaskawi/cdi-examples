package com.github.altanis.arquillian.core.items.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import com.github.altanis.arquillian.core.items.Item;
import com.github.altanis.arquillian.core.items.ItemsRepository;

@ApplicationScoped
public class LinkedListItemsRepository implements ItemsRepository {

    private List<Item> list = new LinkedList<>();

    @Override
    public void addItem(Item item) {
        item.setId(1L);
        list.add(item);
    }

    @Override
    public Collection<Item> getAllItems() {
        return Collections.unmodifiableCollection(list);
    }
}
