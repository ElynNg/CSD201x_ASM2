class Node<T> {
    T info;
    Node nextNode;

    Node(T data, Node<T> p){
        this.info = data;
        this.nextNode = p;
    }

    Node(T data){
        this.info = data;
    }

    Node getNextNode(){
        return this.nextNode;
    }

    String getData(){
        return this.info.toString();
    }

    void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    void setData(T data){
        this.info = data;
    }
}
