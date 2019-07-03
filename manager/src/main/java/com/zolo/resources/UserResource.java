package com.zolo.resources;


@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@Slf4j
public class UserResource {

    public boolean subscribe(String userId, Geyser geyser){


        return false;
    }


    public boolean switchOnGeyser(String userId, Geyser geyser){
        //need to acquire lock on geyser first
        return false;
    }


    public boolean switchOffGeyser(String userId, Geyser geyser){
        //only user having the lock can switch off geyser
        return false;
    }


}
