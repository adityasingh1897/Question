package DesignPattern.Creational.abstractFactory;

public class FactoryProducer {
    public VehicleFactory getFactory(String category){
        if(category.equalsIgnoreCase("Ordinary")){
            return new OrdinaryVehicleFactory();
        }else if (category.equalsIgnoreCase("Luxury")){
            return new LuxuryVehicleFactory();
        }
        return null;
    }
}
