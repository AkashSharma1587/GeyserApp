package com.app.subscription.internal;

import com.app.subscription.model.Subscription;

public interface SubscriptionService {
     Subscription createSubscription(String userId);

     boolean completeSubscription(String userId);
}
