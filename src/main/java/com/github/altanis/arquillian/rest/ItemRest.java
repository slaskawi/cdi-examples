package com.github.altanis.arquillian.rest;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import com.github.altanis.arquillian.core.cdi.ItemCreatedEvent;
import com.github.altanis.arquillian.core.cdi.LoggingInterceptor;
import com.github.altanis.arquillian.core.items.Item;
import com.github.altanis.arquillian.core.items.ItemsRepository;

@Path(ItemRest.ITEM_REST_PATH)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@LoggingInterceptor
public class ItemRest {

    public static final String ITEM_REST_PATH = "/items";

    @Inject
    Event<Item> allCreatedEvent;

    @Inject
    @ItemCreatedEvent
    Event<Item> itemCreatedEvent;

    @Inject
    @Any
    private ItemsRepository repository;

    @GET
    @Path("/")
    @LoggingInterceptor
    public Collection<Item> getAllOrders() {
        return repository.getAllItems();
    }

    @GET
    @Path("{id}")
    public Response getSpecific(@PathParam("id") Long id) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @POST
    @Transactional()
    public Response createNew(@NotNull @Valid Item item, @Context UriInfo uriInfo) {
        itemCreatedEvent.fire(item);
        allCreatedEvent.fire(item);
        UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri()).path("{id}");
        repository.addItem(item);
        return Response.created(uriBuilder.build(uriBuilder.build(item.getId()))).build();
    }
}
