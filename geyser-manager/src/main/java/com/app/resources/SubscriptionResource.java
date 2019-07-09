package com.app.resources;

import com.app.subscription.internal.*;
import com.app.subscription.model.Subscription;
import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/app/geyser/subscription")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {

    private final Provider<SubscriptionService> subscriptionServiceProvider;

    @Inject
    public SubscriptionResource(Provider<SubscriptionService> subscriptionServiceProvider){
        this.subscriptionServiceProvider = subscriptionServiceProvider;
    }
    /**
     *
     * @param userId id of the user who wants to subscribe to Geyser services
     * @return
     */

    @Path("/subscribe/user/{user_id}")
    @POST
    public Subscription subscribe(@QueryParam("user_id") String userId){
        return subscriptionServiceProvider.get().createSubscription(userId);
    }


    @Path("/unsubscribe/user/{user_id}")
    @POST
    public boolean unsubscribe(@QueryParam("user_id") String userId){
        return subscriptionServiceProvider.get().completeSubscription(userId);
    }









}
