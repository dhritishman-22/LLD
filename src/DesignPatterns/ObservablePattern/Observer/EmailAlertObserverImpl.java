package DesignPatterns.ObservablePattern.Observer;

import DesignPatterns.ObservablePattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId);
    }

    private void sendEmail(String emailId) {
        // send email
        System.out.println("Email Alert sent to " + emailId + " with message: " + "Limited stocks, hurry up!");
    }
}
