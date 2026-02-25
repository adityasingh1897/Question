package DesignPattern.Behavioural.strategyPattern.withStrategy;

import DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy.SportyDrive;

public class OffRoadVehicle extends Vehicle {
   OffRoadVehicle(){
       super(new SportyDrive());
   }
}
