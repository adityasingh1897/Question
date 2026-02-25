package DesignPattern.Behavioural.strategyPattern.withStrategy;

import DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy.NormalDrive;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle(){
        super(new NormalDrive());
    }
}
