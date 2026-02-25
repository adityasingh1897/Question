package DesignPattern.Structural.decorator;

public class Mushroom extends ToppingDecorator{
    private final BasePizza basePizza;
    Mushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 40;
    }
}
