package ObservablePattern.Observer;

import ObservablePattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage(userName);
    }

    private void sendMessage(String userName) {
        // send email
        System.out.println("Mobile Alert sent to " + userName + " with message: " + "Limited stocks, hurry up!");
    }
}
