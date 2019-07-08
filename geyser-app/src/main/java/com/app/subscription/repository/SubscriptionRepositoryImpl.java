package com.app.subscription.repository;

import com.google.inject.Inject;
import com.app.subscription.model.Subscription;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import java.util.Optional;

public class SubscriptionRepositoryImpl extends AbstractDAO<Subscription>
        implements SubscriptionRepository {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    @Inject
    public SubscriptionRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Subscription> getActiveSubscription(String userId) {
        Subscription subscription = (Subscription) criteria()
                .add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("endTime", null))
                .uniqueResult();
        return Optional.ofNullable(subscription);
    }

    @Override
    public Optional<Subscription> createSubscription(String userId, DateTime startTime) {
        Subscription subscription = Subscription.builder().userId(userId).startTime(startTime).build();
        persist(subscription);
        return Optional.ofNullable(subscription);
    }

    @Override
    public boolean completeSubscription(Subscription subscription, DateTime endTime) {
        subscription.setEndTime(endTime);
        persist(subscription);
        return true;
    }
}
