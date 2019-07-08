package com.app.subscription.internal;

import com.app.subscription.model.Subscription;

public interface SubscriptionService {
    public Subscription createSubscription(String userId);

    public boolean completeSubscription(String userId);
}
