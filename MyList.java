class MyList<T> {
    Node head;
    Node tail;

    /*
       insert new product to head of the linked list
       @param data: product's information
     */
    void insertToHead(Product data){
        //create new Node
        Node newNode = new Node(data);

        //set newNode as linked list head
        newNode.setNextNode(head);

        //update linked list new head
        head = newNode;

        //if there is only one node
        // head = tail
        if (head.getNextNode() == null){
            tail = head;
        }
    }

    /*
        insert new node to the end of the linked list
        @param data: product's information
     */
    void insertToTail(Product data){
        //create new node
        Node newNode = new Node(data);

        //if the current linked list is empty then add new node to head of the list
        if (this.head == null){
            insertToHead(data);
        }
        //else add new node to the end
        else {
            //set the current tail's nextNode is our new node
            tail.setNextNode(newNode);
            //update the tail
            tail = newNode;
        }
    }

    /*
        find the length of the list
        return length of the list
     */
    int length(){
        int length = 0;

        //start from linked list head
        Node current = this.head;

        //count++ and move pointer to the new node
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    /*
        traverse item from the list
     */
    void traverse(String fileName){
        Node current = head;

        if (current == null){
            System.out.println("Product list is empty");
            OperationToProduct.writeAppendToFile(fileName, "Product list is empty");
        }
        else {
            System.out.printf("%5s | %10s | %5s | %5s \n", "ID", "Title", "Quantity", "Price");
            System.out.println("-------------------------------------");
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNextNode();
            }
        }
    }

    /*
        traverse item by their index
        @param index: product's index in the list
     */
    String traverseItem(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNextNode();
        }
        return current.getData();
    }

    void clear(){
        while (head != null){
            head = head.getNextNode();
        }
    }

    void deleteAtHead() {
        head = head.nextNode;
    }

    void deleteAtTail() {
        Node current = head;
        while (current.getNextNode().getNextNode() != null){
            current = current.getNextNode();
        }
        current.nextNode = null;
        tail = current;
    }

    void deleteAtIndex(int index){
        Node current = head;
        Node prev = head;
        int length = length();

        if (index > length){
            System.out.println("index > length");
            return;
        }

        if (index == 1){
            deleteAtHead();
            return;
        }

        if (index == length){
            deleteAtTail();
            return;
        }

        while (--index > 0){
            prev = current;
            current = current.getNextNode();
        }
        prev.nextNode = current.getNextNode();
    }
}
