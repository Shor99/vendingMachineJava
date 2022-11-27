import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        String password;
        int numOfProduct = 0;
        int productNumber = 1;
        double sumOfCoins = 0.0;
        double coin = 0.0;
        double change;
        int exit;
        boolean on = true;
        ArrayList<Products> products = new ArrayList<>();
        VendingMachine vendingMachine = new VendingMachine();
        HandyMan handyMan = new HandyMan("John");
        Beverages cola = new Beverages("Coca Cola",6);
        Beverages fanta = new Beverages("Fanta",6);
        Beverages fuzeTea = new Beverages("Fuze Tea",8);

        Snacks mars = new Snacks("Mars",7);
        Snacks sniders = new Snacks("Mars",9);
        Snacks popcorn = new Snacks("popcorn",12);

        products.add(cola);
        products.add(fanta);
        products.add(fuzeTea);
        products.add(sniders);
        products.add(popcorn);
        products.add(mars);

        while(on){

            Scanner sc = new Scanner(System.in);
            int num = 0;
            System.out.println("");
            for (Products product : products){
                System.out.println(productNumber++ + " - " + product.getName() + " -> " + product.getPrice() + " -> left: " + product.getNumOfProduct());
                num += product.getNumOfProduct();
            }
            productNumber = 1;
            System.out.println("\nPress -1 to exit the program\nPress 0 to continue");
            exit = sc.nextInt();
            if(exit == -1)
                break;
            System.out.println("Hello, Enter \n1-buyer\n0-handy man");
            input = sc.next();
            if(num == 0)
                System.out.println("no items left to buy");
            if(input.equals("0")){
                System.out.println("Enter Password");
                password = sc.next();
                if(handyMan.checkIfHandyMan(password)){
                    for (Products product : products){
                        System.out.println(product.getName() + " -> " + product.getPrice()+ " shekel " + " -> left: "+product.getNumOfProduct());
                    }
                    System.out.println("\n0-reset\n1-exit");
                    if (sc.next().equals("0")){
                        for (Products product : products){
                            product.setNumOfProduct(product.getDuplicates());
                        }
                    }
                    else{
                        continue;
                    }
                }
                else{
                    System.out.println("wrong password, exiting");
                    continue;
                }
            }
            if(input.equals("1")) {
                System.out.println("Choose the product:");
                for (Products product : products) {
                    System.out.println(productNumber++ + " - " + product.getName() + " -> " + product.getPrice() + " -> left: " + product.getNumOfProduct());
                }
                productNumber = 1;
                numOfProduct = sc.nextInt();
                switch (numOfProduct) {
                    case 1:
                        if(products.get(0).getNumOfProduct() == 0){
                            System.out.println("no items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(0).getPrice());
                        products.get(0).setNumOfProduct(products.get(0).getNumOfProduct() - 1);
                        break;
                    case 2:
                        if(products.get(1).getNumOfProduct() == 0){
                            System.out.println("no items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(1).getPrice());
                        products.get(1).setNumOfProduct(products.get(1).getNumOfProduct() - 1);
                        break;
                    case 3:
                        if(products.get(2).getNumOfProduct() == 0){
                            System.out.println("\nno items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(2).getPrice());
                        products.get(2).setNumOfProduct(products.get(2).getNumOfProduct() - 1);
                        break;
                    case 4:
                        if(products.get(3).getNumOfProduct() == 0){
                            System.out.println("\nno items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(3).getPrice());
                        products.get(3).setNumOfProduct(products.get(3).getNumOfProduct() - 1);
                        break;
                    case 5:
                        if(products.get(4).getNumOfProduct() == 0){
                            System.out.println("\nno items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(4).getPrice());
                        products.get(4).setNumOfProduct(products.get(4).getNumOfProduct() - 1);
                        break;
                    case 6:
                        if(products.get(5).getNumOfProduct() == 0){
                            System.out.println("\nno items to buy");
                            continue;
                        }
                        System.out.println("\nThe price is: " + products.get(5).getPrice());
                        products.get(5).setNumOfProduct(products.get(5).getNumOfProduct() - 1);
                        break;
                    default:
                        System.out.println("\nWrong number, try again");
                        continue;
                }
                System.out.println("\nInsert a coin\ncoin excepted:\n0.1 shekels\n1 shekel\n2 shekel\n5 shekels\n10 shekels");
                while (sumOfCoins < products.get(numOfProduct - 1).getPrice()) {
                    coin = sc.nextInt();
                    if (coin == 0.1 || coin == 1 || coin == 2 || coin == 5 || coin == 10)
                        sumOfCoins += coin;
                    else{
                        System.out.println("not a coin,try again");
                    }
                }
                change = sumOfCoins - products.get(numOfProduct - 1).getPrice();
                System.out.println("paid: " + sumOfCoins);
                System.out.println("change: " + change);
                change = 0.0;
                sumOfCoins = 0.0;
                continue;
            }
        }

    }
}