package printer.basicprinter;

public class Runner {
    public static void main(String[] args) {
        Printer printerUser1 = Printer.getInstance();
        printerUser1.print();

        Printer printerUser2 = Printer.getInstance();
        printerUser2.print();

        System.out.println("Are both printers the same?");
        System.out.println(printerUser1 == printerUser2);

        printerUser1.stopPrinting();
        printerUser2.stopPrinting();

        //this singleton is not thread safe race condition may happen when 2 or more thread
        //try to call getInstance method and end up reading null even though instance as created
        //so the first time instance creation must be thread safe
        //all method are added in readme to make it thread safe
        //using enum is best bcs jvm take cares of creating only 1 instance on first class loading
        //it provides both lazy initialization and thread safety

    }
}
