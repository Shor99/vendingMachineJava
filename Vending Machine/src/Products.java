import java.util.ArrayList;

public class Products extends VendingMachine{
    private String name;
    private int price;

    private int numOfProduct = 2;

    final int duplicates = 2;

    public Products(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public int getNumOfProduct() {
        return numOfProduct;
    }

    public void setNumOfProduct(int numOfProduct) {
        this.numOfProduct = numOfProduct;
    }
}
