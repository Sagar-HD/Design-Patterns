package virtualProxy;


public class ProxyLocker implements Locker{
    private int correctAttempts = 0;
    private RealLocker realLocker=null;
    @Override
    public boolean open(String password) {

        if (!"Sagar".equals(password)) {
            System.out.println("Wrong password");
            return false;
        }

        correctAttempts++;

        if(correctAttempts<2){

            return false;

        }
        if(realLocker==null){
            realLocker=new RealLocker();
        }
        return realLocker.open(password);

    }
}
