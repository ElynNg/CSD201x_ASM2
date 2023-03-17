import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class OperationToProduct {
    /*
        display function menu
     */
    static int menu() {
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

    /*
        receive string and split to id, title, quantity, price of the product
        @param s: string read from file
        return product
     */
    static Product createProduct(String s) {
        //create new product
        Product p = new Product();

        //cut string into id, title, quantity, price
        String[] temp = s.split("\\|");

        //eliminates leading and trailing spaces
        //set as product ID, title, quantity, price
        p.setID(temp[0].trim());
        p.setTitle(temp[1].trim());
        p.setQuantity(Integer.parseInt(temp[2].trim()));
        p.setPrice(Double.parseDouble(temp[3].trim()));
        return p;
    }

    /*
        add new product to linked list
        return product
     */
    static Product createProduct(String fileName, MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        //create new product
        Product p = new Product();
        //use for check id
        boolean check;
        String id;
        //check if the id already existed or not
        do {
            System.out.println("Item ID: ");
            id = input.next();
            //false if the id already existed
            check = checkID(fileName, id, list);
        }
        while (check == false);
        p.setID(id);
        input.nextLine();

        System.out.println("Item Title: ");
        p.setTitle(input.nextLine());

        System.out.println("Item Quantity: ");
        p.setQuantity(input.nextInt());

        System.out.println("Item Price: ");
        p.setPrice((Double) input.nextDouble());

        return p;
    }

    /*
        check if the ID is already existed or not
        @param id: user entered ID
        return true if the ID is usable
     */
    static boolean checkID(String fileName, String id, MyList<Product> list){
        //start from head
        Node current = list.head;

        //check if id exists
        while (current != null){
            if (current.info.getID().equalsIgnoreCase(id)){
                System.out.println("ID already existed");
                writeAppendToFile(fileName, "ID already existed");
                return false;
            }
            current = current.getNextNode();
        }
        return true;
    }

    /*
        read information from file
        @param fileName: name of the product file
        @param list: list of string read from file
        return list of string
     */
    static ArrayList<String> readFromFile(String fileName, ArrayList<String> list){
        String temp = " ";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            //read line by line from file then add it to ArrayList
            while ((temp = br.readLine()) != null) {
                list.add(temp);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /*
        read string from file, then cut id, title, quantity and price of the product
        save to linked list
        @param fileName: name of the product file
        @param list: product list
     */
    static void getAllItemsFromFile(String fileName, MyList<Product> list) {
        //for store string
        ArrayList<String> productString = new ArrayList<>();

        //read file
        productString = readFromFile(fileName, productString);

        //first line is the table title
        //2nd line is a horizontal line
        //so start from the 3rd
        for (int i = 2; i < productString.size(); i++) {
            //insert new product to the end of the linked list
            list.insertToTail(createProduct(productString.get(i)));
        }

        System.out.println("Successfully!");

    }


    /*
        read string from file, then cut id, title, quantity and price of the product
        save to stack
        reverse stack to display
        display stack
        @param fileName: name of the product file
        @param list: product stack
     */
    static void getAllItemsFromFile(String fileName, MyStack<Product> list){
        //store string received from file
        ArrayList<String> productString = new ArrayList<>();

        //read file
        productString = readFromFile(fileName, productString);

        //first line is the table title
        //2nd line is a horizontal line
        //so start from the 3rd
        for (int i = 2; i < productString.size(); i++){
            //push new product to the queue
            list.push(createProduct(productString.get(i)));
        }

        //display reversed stack
        list.display(list.top);
    }

    /*
        read string from file, then cut id, title, quantity and price of the product
        save to queue
        @param fileName: name of the product file
        @param list: product queue
     */
    static void getAllItemsFromFile(String fileName, MyQueue<Product> list) {
        //store string received from file
        ArrayList<String> productString = new ArrayList<>();

        //read file
        productString = readFromFile(fileName, productString);

        //first line is the table title
        //2nd line is a horizontal line
        //so start from the 3rd
        for (int i = 2; i < productString.size(); i++){
            //add new product to queue
            list.enqueue(createProduct(productString.get(i)));
        }
    }

    /*
        write item to file
        @param fileName: name of the output file
        @param list: product list
        @param length: length of the product list
     */
    static void writeAllItemsToFile(String fileName, MyList<Product> list, int length) {
        try {
            FileWriter fw = new FileWriter(fileName);
            //traverse every single line
            //write it into output file
            fw.write(String.format("%5s | %10s | %5s | %5s \n", "ID", "Title", "Quantity", "Price"));
            fw.write("-------------------------------------\n");
            for (int i = 0; i < length; i++){
                fw.write(list.traverseItem(i));
                fw.write("\n");
            }
            fw.close();
        }
        catch( Exception e){
            System.out.println(e);
        }
    }

    static void writeMenuAppendToFile(String fileName, String s){
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write("Choose one of these options: \n");
            fw.write("Product list: \n");
            fw.write("1. Load data from file and display \n");
            fw.write("2. Input & add to the end \n");
            fw.write("3. Display data \n");
            fw.write("4. Save product list to file\n");
            fw.write("5. Search by ID\n");
            fw.write("6. Delete by ID\n");
            fw.write("7. Sort by ID\n");
            fw.write("8. Convert to Binary\n");
            fw.write("9. Load to stack and display\n");
            fw.write("10. Load to queue and display\n");
            fw.write("0. Exit\n");
            fw.write(s + "\n");
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /*
        to write output to outputFile
     */
    static void writeAppendToFile(String fileName, MyList<Product> list){
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(String.format("%5s | %10s | %5s | %5s \n", "ID", "Title", "Quantity", "Price"));
            fw.write("-------------------------------------\n");
            Node current = list.head;
            while (current != null){
                bw.write(current.getData());
                bw.write("\n");
                current = current.getNextNode();
            }
            bw.write("---------------------------------------------------------------------------------------------------\n");
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /*
        to print error to output file
     */
    static void writeAppendToFile(String fileName, String s){
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(s + " \n");
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    /*
        search product by ID that user entered
        @param list: product list
     */
    static void searchByID(String fileName, MyList<Product> list){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert item ID to search: ");
        String id = input.next();

        System.out.println("Result: ");
        String s = search(id, list);
        System.out.println(s);
        if (s.equalsIgnoreCase("-1")){
            writeAppendToFile(fileName, "Result: \n" + s);
        }

    }

    /*
        search item by id
        @param id: product's id to be searched
        return string of product's data
     */
    static String search(String id, MyList<Product> list){
        Node current = list.head;
        while (current != null){
            if (current.info.getID().equalsIgnoreCase(id)){
                return current.getData();
            }
            current = current.getNextNode();
        }
        return "-1";
    }

    /*
        delete product by ID that user entered
        @param list: product list
     */
    static void deleteByID(String fileName, MyList<Product> list){
        Scanner input = new Scanner(System.in);

        System.out.println("Insert item ID to delete: ");
        String id = input.next();

        Node current = list.head;
        Node prev = null;
        boolean exist = false;

        if (current.info.getID().equalsIgnoreCase(id)) {
            list.head = current.getNextNode();
            exist = true;
        }
        while (current != null){
            if (!current.info.getID().equalsIgnoreCase(id)){
                prev = current;
                current = current.getNextNode();
            }
            else {
                exist = true;
                if (current.getNextNode() == null){
                    prev.setNextNode(null);
                    current = null;
                }
                else if (current.getNextNode().getNextNode() == null){
                    prev.setNextNode(current.getNextNode());
                    current = null;
                }
                else {
                    prev.setNextNode(current.getNextNode());
                    current = current.getNextNode().getNextNode();
                }
            }
        }

        if (exist){
            System.out.println("Deleted!");
            writeAppendToFile(fileName, "Deleted!");
        }
        else {
            System.out.println("No result!");
            writeAppendToFile(fileName, "No result!");
        }
    }


    /*
        sort product by ascending follow the alphabet
        @param list: product list
     */
    static void sortByID(MyList<Product> list){
        Node current = list.head, index;

        if (list.head == null){
            return;
        }
        else {
            while (current != null){
                index = current.getNextNode();

                while (index != null){
                    if (current.info.getID().compareTo(index.info.getID()) > 0){
                        Product temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                    index = index.getNextNode();
                }
                current = current.getNextNode();
            }
        }
    }

    /*
        convert product quantity into binary using recursion
        @param list: product list
     */
    static String convertToBinary(String fileName, Node head){
        int quantity = head.info.getQuantity();
        String binary = "";
        binary += convert(String.valueOf(quantity));
        writeAppendToFile(fileName, binary);
        return binary;
    }

    /*
        convert product quantity into binary using recursion
        @param decNumber: product's quantity
        return binary
     */
    static String convert(String decS){
        int decNumber = Integer.parseInt(decS);
        if (decNumber == 0){
            return "0";
        }
        else {
            return String.valueOf(decNumber % 2 + 10 * Integer.parseInt(convert(String.valueOf(decNumber / 2))));
        }
    }
}
