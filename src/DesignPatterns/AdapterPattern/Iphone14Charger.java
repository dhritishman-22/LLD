package DesignPatterns.AdapterPattern;

// Adaptee class
public class Iphone14Charger implements Charger {

    @Override
    public void charge() {
        System.out.println("Charging with Iphone 14 Charger");
    }
}
