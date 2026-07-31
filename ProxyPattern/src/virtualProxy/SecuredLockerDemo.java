package virtualProxy;

public class SecuredLockerDemo {
    public static void main(String[] args) {
        Locker proxyLocker = new ProxyLocker();
        User user = new User(proxyLocker);
        //see this a secret locker
        //implented by an cyber security expert
        //even if u gave crt password it will not open
        //Only after two attemps it will actualy create locker and reuses it after 2 nd attempt onwards


        //if hacker tries 2 times and fails he tries other password
        //but only true owner can enter same password again and again

        //just kidding this is for fun


        user.openLocker("Sagar");
        user.openLocker("Sagar");
        user.openLocker("Sagar");
        user.openLocker("Something");




    }
}
