package com.app.subscription.repository;

import com.app.subscription.model.Subscription;
import org.joda.time.DateTime;

import java.util.Optional;

public interface SubscriptionRepository {
    public Optional<Subscription> getActiveSubscription(String userId);

    public Optional<Subscription> createSubscription(String userId, DateTime startTime);

    public boolean completeSubscription(Subscription subscription, DateTime endTime);
}
