package DesignPattern.Structural.decorator;

public class ExtraCheese extends ToppingDecorator{
    private final BasePizza basePizza;
    ExtraCheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
