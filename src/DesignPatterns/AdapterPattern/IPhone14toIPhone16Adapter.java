package DesignPatterns.AdapterPattern;

// Adapter class
public class IPhone14toIPhone16Adapter implements Charger {

    Iphone14Charger iphone14Charger;

    public IPhone14toIPhone16Adapter() {
        iphone14Charger = new Iphone14Charger();
    }

    @Override
    public void charge() {
        iphone14Charger.charge();
    }
}
