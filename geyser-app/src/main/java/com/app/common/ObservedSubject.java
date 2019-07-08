package com.app.common;

public interface ObservedSubject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}
