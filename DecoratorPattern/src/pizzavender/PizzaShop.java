package pizzavender;

import pizzavender.addOnItems.Cheese;
import pizzavender.addOnItems.Corn;
import pizzavender.addOnItems.Ketchup;
import pizzavender.allPizzas.VegLoaded;
import pizzavender.allPizzas.VideshiHotSauce;
import pizzavender.constants.PizzaSize;

import java.util.Scanner;
//this pizza shop is not closed for modification whenever we need to add or remove pizza
//we should modify this file so , we should move that new instance creation which is changeable part and encapsulte it
public class PizzaShop {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 for veg loaded");
        System.out.println("enter 2 for videshi hot sauce");
        int pizzaType=sc.nextInt();
        sc.nextLine();
        System.out.println("enter 1 for small");
        System.out.println("enter 2 for medium");
        System.out.println("enter 3 for large");
        int sizeType=sc.nextInt();
        sc.nextLine();
        System.out.println("add ons :");
        System.out.println("enter 1 for cheese" +" enter 2 for corn" +" enter 3 for ketchup");
        int addOnType=sc.nextInt();
        sc.nextLine();

        if(pizzaType==1){
        Pizza pizza=null;
        if(sizeType==1){
            pizza=new VegLoaded(PizzaSize.S);
        }else if(sizeType==2){
            pizza=new VegLoaded(PizzaSize.M);
        }else{
            pizza=new VegLoaded(PizzaSize.L);
        }
        if(addOnType==1){
            pizza=new Cheese(pizza);
        }else if(addOnType==2){
            pizza=new Corn(pizza);
        }else if(addOnType==3){
            pizza=new Ketchup(pizza);
        }
        pizza.display();
        }
        else if(pizzaType==2){
            Pizza pizza=null;
            if(sizeType==1){
                pizza=new VideshiHotSauce(PizzaSize.S);
            }else if(sizeType==2){
                pizza=new VideshiHotSauce(PizzaSize.M);
            }else{
                pizza=new VideshiHotSauce(PizzaSize.L);
            }
            if(addOnType==1){
                pizza=new Cheese(pizza);
            }else if(addOnType==2){
                pizza=new Corn(pizza);
            }else if(addOnType==3){
                pizza=new Ketchup(pizza);
            }
            pizza.display();
        }










    }
}
