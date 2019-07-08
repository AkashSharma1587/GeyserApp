package com.app.user.dto;

import com.app.common.Observer;
import com.app.healthcheck.GeyserHealthMonitor;

public class GeyserObserver implements Observer<GeyserUpdate> {
    private final GeyserHealthMonitor subject;

    public GeyserObserver(GeyserHealthMonitor subject){
        this.subject = subject;
    }

    @Override
    public void update(GeyserUpdate update) {


    }
}
