package com.app.resources;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app/geyser/billing")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class BillingResource {

    @Path("/user/{user_id}")
    @GET
    public void generateBill(@PathParam("user_id") String userId){

    }
}
