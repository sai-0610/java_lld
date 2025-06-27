import observer.User;
import observable.iPhone15Stock;

public class Main {
    public static void main(String[] args) {
        iPhone15Stock stock = new iPhone15Stock(5);

        User user1 = new User("Alice", "alice@example.com");
        User user2 = new User("Bob", "9123456789");

        stock.add(user1);
        stock.add(user2);

        stock.sell(2);
        stock.addStock(4);
        stock.sell(7);
    }
}
