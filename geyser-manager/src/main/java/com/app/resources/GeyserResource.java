package com.app.resources;


import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/app/geyser")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class GeyserResource {


    /**
     *
     * @param userId user_id which uniquely identifies a particular user
     * @param action will be ON/OFF
     * @return
     */
    @Path("/user/{user_id}/action/{action}")
    @POST
    public boolean operateGeyser(@PathParam("user_id") String userId, @PathParam("action") String action){
        // Check if user has active subscription
        //need to acquire lock on geyser first
        return false;
    }

}
