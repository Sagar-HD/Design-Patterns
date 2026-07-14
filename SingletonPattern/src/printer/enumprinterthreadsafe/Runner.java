package printer.enumprinterthreadsafe;

public class Runner {
    public static void main(String[] args) {
        Printer printerUser1=Printer.INSTANCE;
        printerUser1.print();
        Printer printerUser2=Printer.INSTANCE;
        printerUser2.print();
        System.out.println("Are both printers the same?");
        System.out.println(printerUser1 == printerUser2);
        printerUser1.stopPrinting();
        printerUser2.stopPrinting();
    }
}
