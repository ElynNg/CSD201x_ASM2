import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyList<Product> productList = new MyList<>();
        MyStack<Product> productStack = new MyStack<>();
        MyQueue<Product> productQueue = new MyQueue<>();
        boolean exit = false;
        String fileName = "src/product.txt";
        String outputFile = "src/outputFile.txt";

        //1. Display function menu
        while (!exit){
            int  choice = OperationToProduct.menu();
            while (choice < 0 && choice > 10){
                choice = OperationToProduct.menu();
            }
            switch(choice){
                case 1:
                    productList.clear();
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.getAllItemsFromFile(fileName, productList);
                    productList.traverse(outputFile);
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 2:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    productList.insertToTail(OperationToProduct.createProduct(outputFile, productList));
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 3:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    productList.traverse(outputFile);
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 4:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.writeAllItemsToFile(fileName, productList, productList.length());
                    System.out.println("Successfully!");
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    OperationToProduct.writeAppendToFile(outputFile, "Successfully!");
                    break;
                case 5:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.searchByID(outputFile, productList);
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 6:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.deleteByID(outputFile, productList);
                    break;
                case 7:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.sortByID(productList);
                    productList.traverse(outputFile);
                    System.out.println("Successfully!");
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 8:
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    System.out.println(OperationToProduct.convertToBinary(outputFile, productList.head));
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 9:
                    productStack.clear();
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.getAllItemsFromFile(fileName, productStack);
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 10:
                    productQueue.clear();
                    OperationToProduct.writeMenuAppendToFile(outputFile, "Choice: " + choice);
                    OperationToProduct.getAllItemsFromFile(fileName, productQueue);
                    productQueue.dequeue();
                    OperationToProduct.writeAppendToFile(outputFile, productList);
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

}