package DesignPattern.Behavioural.observerPattern;

import DesignPattern.Behavioural.observerPattern.observable.IphoneObservableImpl;
import DesignPattern.Behavioural.observerPattern.observable.StockObservable;
import DesignPattern.Behavioural.observerPattern.observer.EmailNotification;
import DesignPattern.Behavioural.observerPattern.observer.NotificationAlertObserver;
import DesignPattern.Behavioural.observerPattern.observer.SMSNotification;

public class Store {
    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneObservableImpl();
        stockObservable.add(new EmailNotification("aditya@gmail.com", stockObservable));
        stockObservable.add(new EmailNotification("vivek@gmail.com", stockObservable));
        stockObservable.add(new SMSNotification("aditya", stockObservable));

        stockObservable.setStockCount(10);
    }
}
