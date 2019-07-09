package com.app.user.dto;

import com.app.common.Observer;
import com.app.healthcheck.GeyserHealthMonitor;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeyserObserver implements Observer<GeyserUpdate> {
    private final GeyserHealthMonitor subject;

    @Inject
    public GeyserObserver(GeyserHealthMonitor subject){
        this.subject = subject;
    }

    @Override
    public void update(GeyserUpdate update) {
        log.info("Message from geyserMonitor, Message {}, Status {}, Time {}", update.getMessage(),
                update.getStatus(), update.getCreatedAt());

    }
}
