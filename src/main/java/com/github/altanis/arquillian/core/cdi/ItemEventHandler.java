package com.github.altanis.arquillian.core.cdi;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Singleton;
import com.github.altanis.arquillian.core.items.Item;

@Singleton
public class ItemEventHandler {

    public static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getCanonicalName());

    public void onAnyItemCreated(@Observes(notifyObserver = Reception.IF_EXISTS) Item i) {
        logger.info("Ohhhh, I see you're creating an item? " + i.getName());
    }

    public void onNewItemCreated(@Observes @ItemCreatedEvent Item i) {
        logger.info("Ohhhh, I see you're creating a NEW item? " + i.getName());
    }

}
