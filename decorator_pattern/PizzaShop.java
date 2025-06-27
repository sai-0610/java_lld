public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza = new Farmhouse();          // Base pizza
        pizza = new ExtraCheese(pizza);             // 1st topping
        pizza = new Mushroom(pizza);                // 2nd topping
        pizza = new ExtraCheese(pizza);             // 3rd topping

        System.out.println("Total Pizza Cost: Rs." + pizza.cost());
    }
}
