package virtualProxy;

import javax.sound.midi.Soundbank;

public class User {
    private Locker locker;

    public User(Locker proxyLocker) {
        this.locker = proxyLocker;
    }


    public void openLocker(String password){
        if(locker.open(password)){
            System.out.println(" yoo locker opened");
        }
        else{
            System.out.println("oops! password was wrong ");
        }

    }
}
