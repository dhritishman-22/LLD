package DesignPatterns.DecoratorPattern;

import DesignPatterns.DecoratorPattern.Decorator.CarDecorator;

public class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Assembling Sports Car");
    }
}
