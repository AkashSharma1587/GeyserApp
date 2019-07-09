package com.app.module;

import com.app.subscription.internal.SubscriptionService;
import com.app.subscription.repository.SubscriptionRepository;
import com.app.subscription.repository.SubscriptionRepositoryImpl;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SubscriptionService.class).to((Class<? extends SubscriptionService>) SubscriptionRepositoryImpl.class);
    }
}
