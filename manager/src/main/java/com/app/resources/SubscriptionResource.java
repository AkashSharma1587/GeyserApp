package com.app.resources;

import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/app/geyser/subscription")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {
    /**
     *
     * @param userId id of the user who wants to subscribe to Geyser services
     * @return
     */

    @Path("/subscribe/user/{user_id}")
    @POST
    public boolean subscribe(@QueryParam("user_id") String userId){

        return false;
    }


    @Path("/unsubscribe/user/{user_id}")
    @POST
    public boolean unsubscribe(@QueryParam("user_id") String userId){


        return false;
    }









}
