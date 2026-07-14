package printer.enumprinterthreadsafe;

public enum Printer {
    INSTANCE;
    private boolean isBusy;
    Printer() {
        System.out.println("Printer initialized at first use ");
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
