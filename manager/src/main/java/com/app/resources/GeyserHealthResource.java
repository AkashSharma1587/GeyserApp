package com.app.resources;


import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/app/geyser/health")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class GeyserHealthResource {

}
