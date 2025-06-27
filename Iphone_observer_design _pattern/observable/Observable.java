package observable;

import observer.Observer;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
    void setData(int stock);
    void showCurrentStock();
    int getStock();
}
