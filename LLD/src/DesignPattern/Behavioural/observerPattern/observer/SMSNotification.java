package DesignPattern.Behavioural.observerPattern.observer;

import DesignPattern.Behavioural.observerPattern.observable.StockObservable;

public class SMSNotification implements NotificationAlertObserver{
    String  userName;
    StockObservable stockObservable;

    public SMSNotification(String userName, StockObservable stockObservable){
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update(){
        sentMessageOnSMS(userName);
    }
    void sentMessageOnSMS(String userName){
        System.out.println("Message Sent to : "+ userName + " Stock is full.");
    }
}
