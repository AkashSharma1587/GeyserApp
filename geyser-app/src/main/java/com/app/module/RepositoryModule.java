package com.app.module;

import com.app.subscription.repository.SubscriptionRepository;
import com.app.subscription.repository.SubscriptionRepositoryImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.Configuration;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

public class RepositoryModule<T extends Configuration> extends AbstractModule {

    private HibernateBundle<T> hibernateBundle;

    @Override
    protected void configure() {
        bind(SubscriptionRepository.class).to(SubscriptionRepositoryImpl.class);
    }

    public RepositoryModule(HibernateBundle<T> hibernate) {
        this.hibernateBundle = hibernate;
    }

    @Provides
    @Singleton
    public SessionFactory providesSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
}
