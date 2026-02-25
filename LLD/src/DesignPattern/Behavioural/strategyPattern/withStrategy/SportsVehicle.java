package DesignPattern.Behavioural.strategyPattern.withStrategy;

import DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy.SportyDrive;

public class SportsVehicle extends Vehicle {
    SportsVehicle(){
        super(new SportyDrive());
    }
}
