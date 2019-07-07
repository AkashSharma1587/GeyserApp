package com.app.resources;


import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/app/geyser")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class GeyserResource {


    @Path("/user/{user_id}/action/{action}")
    @POST
    public boolean operateGeyser(@QueryParam("user_id") String userId, @QueryParam("action") String action){
        //need to acquire lock on geyser first
        return false;
    }

}
