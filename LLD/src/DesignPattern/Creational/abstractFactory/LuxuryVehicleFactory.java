package DesignPattern.Creational.abstractFactory;

public class LuxuryVehicleFactory implements VehicleFactory{

    @Override
    public Vehicle getVehicle(String type) {
        if(type.equalsIgnoreCase("BMW")){
            return new BMW();
        } else if (type.equalsIgnoreCase("MERCEDECE")) {
            return new Mercedece();
        }
        return null;
    }
}
