import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

class OperationToProduct {
    static int menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one of these options: ");
        System.out.println("Product list: ");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.println("Your choice: ");
        return input.nextInt();
    }

    int index(Product p, MyList<Product> list){
        return -1;
    }
    
    static Product createProduct(String s){
        Product p = new Product();
        String[] temp = s.split("\\|");
        p.setID(temp[0].trim());
        p.setTitle(temp[1].trim());
        p.setQuantity(Integer.parseInt(temp[2].trim()));
        p.setPrice(Double.parseDouble(temp[3].trim()));
        return p;
    }

    static Product createProduct(){
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        System.out.println("Item ID: ");
        p.setID(input.nextLine());

        System.out.println("Item Title: ");
        p.setTitle(input.nextLine());

        System.out.println("Item Quantity: ");
        p.setQuantity(input.nextInt());

        System.out.println("Item Price: ");
        p.setPrice((Double)input.nextDouble());

        return p;
    }

    static void getAllItemsFromFile(String fileName, MyList<Product> list) throws FileNotFoundException {
        ArrayList<String> productString = new ArrayList<>();
        String temp = " ";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((temp = br.readLine()) != null){
                productString.add(temp);
            }
            br.close();
            fr.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Success");
        for (int i = 2; i < productString.size(); i++){
            list.insertToTail(createProduct(productString.get(i)));
        }
    }


}
