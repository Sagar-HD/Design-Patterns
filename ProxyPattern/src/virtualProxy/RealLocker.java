package virtualProxy;

public class RealLocker implements Locker{
    private String password="Sagar";

    @Override
    public boolean open(String password) {
        return this.password.equals(password);
    }
}
