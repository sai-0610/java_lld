import java.util.Scanner;

public class PizzaShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your base pizza:");
        System.out.println("1. Margerita (₹150)");
        System.out.println("2. FarmHouse (₹180)");
        System.out.println("3. VegDelight (₹200)");
        System.out.print("Enter choice (1-3): ");
        int baseChoice = sc.nextInt();

        BasePizza pizza;
        if (baseChoice == 1) {
            pizza = new Margherita();
        } else if (baseChoice == 2) {
            pizza = new Farmhouse();
        } else if (baseChoice == 3) {
            pizza = new VegDelight();
        } else {
            System.out.println("Invalid choice. Defaulting to Margerita.");
            pizza = new Margherita();
        }

        boolean addMore = true;
        while (addMore) {
            System.out.println("Add a topping:");
            System.out.println("1. Extra Cheese (+₹20)");
            System.out.println("2. Mushroom (+₹10)");
            System.out.println("3. No more toppings");
            System.out.print("Enter choice (1-3): ");
            int toppingChoice = sc.nextInt();

            if (toppingChoice == 1) {
                pizza = new ExtraCheese(pizza);
            } else if (toppingChoice == 2) {
                pizza = new Mushroom(pizza);
            } else if (toppingChoice == 3) {
                addMore = false;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Total Pizza Cost: ₹" + pizza.cost());
        sc.close();
    }
}
