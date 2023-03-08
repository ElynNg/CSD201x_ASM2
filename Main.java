import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Product newProduct = new Product("P04", "Sugar", 5, 5.4);
        MyList<Product> productList = new MyList<>();
        boolean exit = false;

        //1. Display function menu
        while (!exit){
            int  choice = OperationToProduct.menu();
            while (choice < 0 && choice > 10){
                choice = OperationToProduct.menu();
            }
            switch(choice){
                case 1:
                    OperationToProduct.getAllItemsFromFile("C:/JAVA/CSD201x/CSD201x_ASM2/src/product.txt", productList);
                    System.out.println("Successfully!");
                    break;
                case 2:
                    productList.insertToTail(OperationToProduct.createProduct());
                    break;
                case 3:
                    productList.traverse();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

}