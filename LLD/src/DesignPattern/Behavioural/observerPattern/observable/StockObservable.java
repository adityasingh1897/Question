package DesignPattern.Behavioural.observerPattern.observable;

import DesignPattern.Behavioural.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
     void add(NotificationAlertObserver notificationAlertObserver);
     void remove(NotificationAlertObserver notificationAlertObserver);
     void notifySubscriber();
     void setStockCount(int newStock);
     int getStockCount();
}
