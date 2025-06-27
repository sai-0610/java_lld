package observer;

public class User implements Observer {
    private String name;
    private String emailOrPhone;

    public User(String name, String emailOrPhone) {
        this.name = name;
        this.emailOrPhone = emailOrPhone;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + " (" + emailOrPhone + "): " + message);
    }
}
