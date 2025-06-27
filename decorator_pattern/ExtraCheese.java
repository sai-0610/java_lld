public class ExtraCheese extends ToppingDecorator {
    @Override
    public int cost() {
        return this.pizza.cost() + 20;
    }
    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }
}
