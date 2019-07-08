package com.app.config;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class GeyserConfiguration extends Configuration {

    @Valid
    @NotNull
    private DataSourceFactory databaseConfiguration = new DataSourceFactory();


}
