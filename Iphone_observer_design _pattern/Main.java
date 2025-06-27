import observer.User;
import observable.iPhone15Stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial stock of iPhone 15: ");
        int initialStock = sc.nextInt();
        sc.nextLine();

        iPhone15Stock stock = new iPhone15Stock(initialStock);

        System.out.print("Enter number of customers to register: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for customer #" + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email or Phone: ");
            String contact = sc.nextLine();
            stock.add(new User(name, contact));
        }

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Sell iPhones");
            System.out.println("2. Add iPhones to stock");
            System.out.println("3. Show current stock");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity to sell: ");
                    stock.sell(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter quantity to add: ");
                    stock.addStock(sc.nextInt());
                    break;
                case 3:
                    stock.showCurrentStock();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }
}
