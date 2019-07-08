package com.app;

import com.app.module.AppModule;
import com.app.module.RepositoryModule;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.palominolabs.metrics.guice.MetricsInstrumentationModule;
import com.app.config.GeyserConfiguration;
import com.app.subscription.model.Subscription;
import com.app.user.model.User;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.DefaultNamingStrategy;


import java.util.TimeZone;

public class GeyserApplication extends Application<GeyserConfiguration> {

    private final HibernateBundle<GeyserConfiguration>
            hibernate =
            new HibernateBundle<GeyserConfiguration>(
                    User.class, Subscription.class
            ) {
                @Override
                public DataSourceFactory getDataSourceFactory(GeyserConfiguration configuration) {
                    return configuration.getDatabaseConfiguration();
                }

                @Override
                public void configure(Configuration configuration) {
                    configuration.setNamingStrategy(new DefaultNamingStrategy());
                }
            };


    public static void main(String[] args) throws Exception {
        new GeyserApplication().run(args);
    }

    @Override
    public void run(GeyserConfiguration configuration, Environment environment) throws Exception {
        environment.getObjectMapper().setPropertyNamingStrategy(
                PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        environment.getObjectMapper().setTimeZone(TimeZone.getTimeZone("GMT+530"));
        environment.jersey().getResourceConfig().getContainerRequestFilters();

    }

    @Override
    public void initialize(final Bootstrap<GeyserConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);

        final GuiceBundle<GeyserConfiguration> guiceBundle =
                new GuiceBundle.Builder<GeyserConfiguration>()
                        .setConfigClass(GeyserConfiguration.class)
                        .addModule(new MetricsInstrumentationModule(bootstrap.getMetricRegistry()))
                        .addModule(new AppModule())
                        .addModule(new RepositoryModule<>(hibernate))
                        .enableAutoConfig(
                                "com.app")
                        .build(Stage.DEVELOPMENT);
        bootstrap.addBundle(guiceBundle);


    }
}
