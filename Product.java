class Product {
    private String id;
    String title;
    int quantity;
    double price;

    Product(){}

    Product(String id, String name, int quantity, double price){
        this.id = id;
        this.title = name;
        this.quantity = quantity;
        this.price = price;
    }

    void setID(String id){
        this.id = id;
    }

    void setTitle(String name){
        this.title = name;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    void setPrice(double price){
        this.price = price;
    }

    String getID(){
        return id;
    }

    String getTitle(){
        return title;
    }

    int getQuantity(){
        return quantity;
    }

    double getPrice(){
        return price;
    }

    void display(){

    }
    public String toString(){
        return getID() + " " + getTitle() + " " + getQuantity() + " " + getPrice();
    }
}
