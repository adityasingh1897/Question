package DesignPattern.Behavioural.observerPattern.observable;

import DesignPattern.Behavioural.observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();
int stockCount =0 ;
    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscriber() {
        for (NotificationAlertObserver notificationAlertObserver : notificationAlertObserverList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStock) {
        if(stockCount == 0){
            notifySubscriber();
        }
        stockCount += newStock;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
