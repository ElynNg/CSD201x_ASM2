class Product {
    private String id;
    String title;
    int quantity;
    double price;

    /*
        Constructor
     */
    Product(){}

    /*
        Constructor
        @param id: id of the product
        @param name: title of the product
        @param quantity: quantity of the product
        @param price: price of the product
     */
    Product(String id, String name, int quantity, double price){
        this.id = id;
        this.title = name;
        this.quantity = quantity;
        this.price = price;
    }

    /*
        set ID
        @param id
     */
    void setID(String id){
        this.id = id;
    }

    /*
        set title
        @param title
     */
    void setTitle(String title){
        this.title = title;
    }

    /*
        set quantity
        @param quantity
     */
    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /*
        set price
        @param price
     */
    void setPrice(double price){
        this.price = price;
    }

    /*
        get ID of the product
        return id
     */
    String getID(){
        return id;
    }

    /*
        get title of the product
        return title
     */
    String getTitle(){
        return title;
    }

    /*
        get the quantity of the product
        return quantity
     */
    int getQuantity(){
        return quantity;
    }

    /*
        get the price of the product
        return price
     */
    double getPrice(){
        return price;
    }

}
