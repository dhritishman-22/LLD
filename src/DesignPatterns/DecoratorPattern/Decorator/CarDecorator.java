package DesignPatterns.DecoratorPattern.Decorator;

import DesignPatterns.DecoratorPattern.Car;

public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
