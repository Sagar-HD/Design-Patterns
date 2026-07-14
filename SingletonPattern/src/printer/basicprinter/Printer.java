package printer.basicprinter;

public class Printer {
    private static Printer instance;
    private boolean isBusy;
    private Printer() {
    }
    public static Printer getInstance(){
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }
    public void print(){
        if(!isBusy){
            isBusy = true;
            System.out.println("printing");
        }
        else{
            System.out.println("sorry printer is busy");
        }
    }
   public void stopPrinting(){
        if(isBusy){
            isBusy = false;
            System.out.println("printing stopped");
        }
        else{
            System.out.println("printer is already stopped");
        }
    }

}
