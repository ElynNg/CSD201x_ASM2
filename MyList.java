class MyList<T> {
    Node<T> head;
    Node<T> tail;

    void insertToHead(T data){
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(head);
        head = newNode;

        if (head.getNextNode() == null){
            tail = head;
        }
    }

    void insertToTail(T data){
        Node<T> newNode = new Node<>(data);
        if (this.head == null){
            insertToHead(data);
        }
        else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    int length(){
        int length = 0;
        Node current = head;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    void traverse(){
        System.out.println("Product list: ");
        Node current = head;
        int length = length();
        for (int i = 0; i < length; i++){
            System.out.println(current.getData());;
            current = current.getNextNode();
        }
    }
}
