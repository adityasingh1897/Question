package DesignPattern.Behavioural.observerPattern.observer;

import DesignPattern.Behavioural.observerPattern.observable.StockObservable;

public class EmailNotification implements NotificationAlertObserver{
    String emailId;
    StockObservable stockObservable;
    public EmailNotification(String emailId, StockObservable stockObservable){
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update(){
        sentMessageOnEmail(emailId);
    }
    void sentMessageOnEmail(String emailId){
        System.out.println("Message Sent to : "+ emailId + " Stock is full.");
    }
}
