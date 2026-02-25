package DesignPattern.Structural.decorator;

public class Order {
    public static void main(String[] args) {
        //Margheeta + ExtraCheese.
        BasePizza pizza = new ExtraCheese(new Margheeta());
        System.out.println(pizza.cost());

        //VegDelight + extracheese + mushroom

        BasePizza pizza1 = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(pizza1.cost());

    }
}
