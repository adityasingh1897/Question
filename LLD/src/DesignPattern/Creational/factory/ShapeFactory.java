package DesignPattern.Creational.factory;

public class ShapeFactory {
    Shape getShape(String input){
        switch (input.toUpperCase()){
            case "CIRCLE" :
                return new Circle();
            case "RECTANGLE" :  return new Rectangle();
            case "SQUARE" : return new Square();
            default: throw new RuntimeException("invalid input");
        }
    }
}
