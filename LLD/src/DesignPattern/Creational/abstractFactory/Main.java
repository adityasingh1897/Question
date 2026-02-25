package DesignPattern.Creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        VehicleFactory ordinary = factoryProducer.getFactory("ordinary");
       Vehicle swift = ordinary.getVehicle("swift");
       swift.getSpeed();

        VehicleFactory luxury = factoryProducer.getFactory("Luxury");
        Vehicle bmw = luxury.getVehicle("Bmw");
        bmw.getSpeed();
    }
}
