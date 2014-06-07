package com.github.altanis.arquillian.core.items;

import java.util.Collection;

public interface ItemsRepository {

    public void addItem(Item item);

    public Collection<Item> getAllItems();

}
