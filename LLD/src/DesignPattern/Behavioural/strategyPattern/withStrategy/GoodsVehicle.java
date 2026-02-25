package DesignPattern.Behavioural.strategyPattern.withStrategy;

import DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy.HeavyDrive;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle(){
        super(new HeavyDrive());
    }
}
