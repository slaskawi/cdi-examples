package com.github.altanis.arquillian.rest;

import java.util.List;
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
import javax.ws.rs.core.UriInfo;
import com.github.altanis.arquillian.core.items.Item;

@Path(ItemRest.ITEM_REST_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class ItemRest {

    public static final String ITEM_REST_PATH = "/items";

    @GET
    @Path("/")
    public List<Item> getAllOrders() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @GET
    @Path("{id}")
    public Response getSpecific(@PathParam("id") Long id) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @POST
    @Transactional
    public Response createNew(@NotNull @Valid Item item, @Context UriInfo uriInfo) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
