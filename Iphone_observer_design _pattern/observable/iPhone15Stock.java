package observable;

import observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class iPhone15Stock implements Observable {
    private int stock;
    private List<Observer> observers;

    public iPhone15Stock(int initialStock) {
        this.stock = initialStock;
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        String message = "iPhone 15 is out of stock!";
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void setData(int stock) {
        this.stock = stock;
        if (this.stock == 0) {
            notifyObservers();
        }
    }

    public void sell(int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
        if (quantity > stock) {
            System.out.println("Cannot sell " + quantity + " units. Only " + stock + " left!");
            return;
        }
        stock -= quantity;
        System.out.println("Sold " + quantity + " iPhone 15(s). Current stock: " + stock);
        if (stock == 0) {
            notifyObservers();
        }
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
        stock += quantity;
        System.out.println("Added " + quantity + " iPhone 15(s). Current stock: " + stock);
    }

    public void showCurrentStock() {
         System.out.println("Current stock: " + stock + " iPhone 15(s).");
    }

    public int getStock() {
    return stock;
    }


}
