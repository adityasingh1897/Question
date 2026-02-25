package DesignPattern.Behavioural.strategyPattern.withStrategy;

import DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy.DriveStrategy;

public class Vehicle {
    public final DriveStrategy driveStrategy;
    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
