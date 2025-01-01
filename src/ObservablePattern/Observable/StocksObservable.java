package ObservablePattern.Observable;

import ObservablePattern.Observer.NotificationAlertObserver;

public interface StocksObservable {

    void registerObserver(NotificationAlertObserver observer);

    void removeObserver(NotificationAlertObserver observer);

    void notifyObservers();

    void setStockCount(int stockCount);

    int getStockCount();
}
