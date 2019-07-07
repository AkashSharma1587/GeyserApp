package com.app.subscription.internal;

public interface SubscriptionService {
    public boolean createSubscription(String userId);

    public boolean completeSubscription(String userId);
}
