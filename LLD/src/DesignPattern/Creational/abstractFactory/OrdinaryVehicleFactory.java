package DesignPattern.Creational.abstractFactory;

public class OrdinaryVehicleFactory implements VehicleFactory{

    @Override
    public Vehicle getVehicle(String type) {
        if(type.equalsIgnoreCase("SWIFT")){
            return new Swift();
        } else if (type.equalsIgnoreCase("HYUNDAI")) {
            return new Hyundai();
        }
        return null;
    }
}
