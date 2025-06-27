package observer;

public class User implements Observer {
    private String name;
    private String contact;

    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + " (" + contact + "): " + message);
    }
}
