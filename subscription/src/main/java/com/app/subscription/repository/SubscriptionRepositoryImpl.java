package com.app.subscription.repository;

import com.google.inject.Inject;
import com.app.subscription.model.Subscription;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
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
        Optional<Subscription> result = Optional.empty();
        return result;
    }

    @Override
    public boolean createSubscription(String userId, DateTime startTime) {
        return false;
    }

    @Override
    public boolean completeSubscription(Subscription subscription, DateTime endTime) {
        return false;
    }
}
