class Node {
    Product info;
    Node nextNode;

    /*
        constructor to create new node
        @param data: new element's information
        @param Node p
     */
    Node(Product data, Node p){
        this.info = data;
        this.nextNode = p;
    }

    /*
        constructor to create new node
        @param data: new element's information
     */
    Node(Product data){
        this.info = data;
    }

    /*
        to get nextNode of the current node
     */
    Node getNextNode(){
        return this.nextNode;
    }

    /*
        to print the data of the elements
     */
    String getData(){
        return String.format("%5s | %10s | %8d | %.1f", info.getID(), info.getTitle(), info.getQuantity(), info.getPrice());
    }

    /*
        to set the nextNode of the current node
        @param nextNode: receive data for nextNode
     */
    void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    /*
        to set data to node
        @param data: node's data
     */
    void setData(Product data){
        this.info = data;
    }
}
