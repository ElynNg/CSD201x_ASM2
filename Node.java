class Node {
    Product info;
    Node nextNode;

    Node(Product data, Node p){
        this.info = data;
        this.nextNode = p;
    }

    Node(Product data){
        this.info = data;
    }

    Node getNextNode(){
        return this.nextNode;
    }

    String getData(){
        return String.format("%5s | %10s | %5d | %.1f", info.getID(), info.getTitle(), info.getQuantity(), info.getPrice());
    }

    void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    void setData(Product data){
        this.info = data;
    }
}
