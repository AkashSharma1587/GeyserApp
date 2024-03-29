package com.app.subscription.internal;

import com.app.exception.BaseException;
import com.app.healthcheck.GeyserHealthMonitor;
import com.app.user.dto.GeyserObserver;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.app.subscription.model.Subscription;
import com.app.subscription.repository.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.ws.rs.core.Response;
import java.util.Optional;

@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;
    private final GeyserHealthMonitor geyserHealthMonitor;

    @Inject
    public SubscriptionServiceImpl(Provider<SubscriptionRepository> subscriptionRepositoryProvider,
                                   GeyserHealthMonitor geyserHealthMonitor){
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.geyserHealthMonitor = geyserHealthMonitor;
    }

    @Override
    public Subscription createSubscription(String userId) {
        //Check if there is an existing active subscription
        //If active subscription present, throw error
        //   Else create new subscription
        //       Add a GeyserObserver instance to the subscriber's list for GeyserHealthMonitor
        //       Return newly created subscription

        SubscriptionRepository subscriptionRepository = subscriptionRepositoryProvider.get();
        Optional<Subscription> subscriptionOptional = subscriptionRepository.getActiveSubscription(userId);
        if(subscriptionOptional.isPresent()){
            log.error("Active Subscription already exists for userId "+userId);
            throw new BaseException(Response.Status.CONFLICT,
                    "SUBSCRIPTION_ALREADY_EXISTS",
                    "An active subscription already exists for User "+userId);
        }
        else{
            DateTime now = DateTime.now();
            Optional<Subscription> subscriptionOp = subscriptionRepository.createSubscription(userId, now);
            if(subscriptionOp.isPresent()){
                log.info("A new subscription created for user : "+userId);
                Subscription subscription = subscriptionOp.get();

                //TODO Need a way to reserve this observer till the subscription exists
                GeyserObserver observer = new GeyserObserver(geyserHealthMonitor);
                geyserHealthMonitor.registerObserver(observer);

                return subscription;
            }
            else{
                throw new BaseException(Response.Status.INTERNAL_SERVER_ERROR, "Error occurred while creating new subscription. Please retry");
            }
        }

    }


    @Override
    public boolean completeSubscription(String userId) {
        // CHeck if there is an existing active subscription
        // If yes,
        //       Remove the GeyserObserver instance attached to GeyserHealthMonitor
        //       Update the subscription entity
        //       Return true
        // If No,
        //       Return false;

        SubscriptionRepository subscriptionRepository = subscriptionRepositoryProvider.get();
        Optional<Subscription> subscriptionOptional = subscriptionRepository.getActiveSubscription(userId);
        if(subscriptionOptional.isPresent()){
            DateTime endTime = DateTime.now();
            return subscriptionRepository.completeSubscription(subscriptionOptional.get(), endTime);
        } else{
            throw new BaseException(Response.Status.NOT_FOUND, "NO_ACTIVE_SUBSCRIPTION_FOUND",
                    "No active subscription found for deactivation for the user "+userId);
        }
    }
}
