import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Enter amount to pay:");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.println("Choose Payment Method: 1. CreditCard  2. UPI  3. PayPal");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter card number:");
                String card = sc.nextLine();
                System.out.println("Enter CVV:");
                String cvv = sc.nextLine();
                System.out.println("Enter Expiry:");
                String expiry = sc.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(card, cvv, expiry));
                break;

            case 2:
                System.out.println("Enter UPI ID:");
                String upi = sc.nextLine();
                context.setPaymentStrategy(new UpiPayment(upi));
                break;

            case 3:
                System.out.println("Enter PayPal email:");
                String email = sc.nextLine();
                context.setPaymentStrategy(new PaypalPayment(email));
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        context.pay(amount);
        sc.close();
    }
}
