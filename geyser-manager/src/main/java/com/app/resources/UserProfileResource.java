package com.app.resources;


import com.app.user.dto.UserProfileRequest;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app/geyser/user")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class UserProfileResource {

    @Path("/create")
    @POST
    public boolean createUserProfile(UserProfileRequest request){


        return false;
    }

}
