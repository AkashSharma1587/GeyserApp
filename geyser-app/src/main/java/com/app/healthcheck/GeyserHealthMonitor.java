package com.app.healthcheck;

import com.app.common.ObservedSubject;
import com.app.common.Observer;
import com.app.user.dto.GeyserObserver;
import com.app.user.dto.GeyserUpdate;
import com.google.inject.Singleton;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GeyserHealthMonitor implements ObservedSubject {


    private final List<Observer> geyserObservers = new ArrayList<>();

    @Override
    public  void registerObserver(Observer o) {
        if(o instanceof GeyserObserver){
            geyserObservers.add(o);
        }
    }

    @Override
    public void unregisterObserver(Observer o) {
         if(o instanceof GeyserObserver)
             geyserObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        //TODO Add condition to check geyser water level. If Geyser water level is 0, raise a GeyserUpdate()
        GeyserUpdate update = new GeyserUpdate();
        update.setMessage("Water level 0");
        update.setStatus("GEYSER_CANNOT_RUN");
        update.setCreatedAt(DateTime.now());
        for(Observer o : geyserObservers){
            o.update(update);
        }

    }
}
