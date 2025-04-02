package DesignPatterns.DecoratorPattern;

import DesignPatterns.DecoratorPattern.Decorator.CarDecorator;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Assembling Luxury Car");
    }
}
