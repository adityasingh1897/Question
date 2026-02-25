package DesignPattern.Behavioural.strategyPattern.withStrategy.driveStrategy;

public class HeavyDrive implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("Heavy Drive");
    }
}
