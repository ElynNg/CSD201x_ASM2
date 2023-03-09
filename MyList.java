import java.util.ArrayList;

class MyList<T> {
    Node head;
    Node tail;

    void insertToHead(Product data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;

        if (head.getNextNode() == null){
            tail = head;
        }
    }

    void insertToTail(Product data){
        Node newNode = new Node(data);
        if (this.head == null){
            insertToHead(data);
        }
        else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    void traverse(){
        System.out.println("Product list: ");
        Node current = head;

        while (current != null){
            System.out.println(current.getData());
            current = current.getNextNode();
        }
    }

    String traverseItem(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNextNode();
        }
        return current.getData();
    }

    String searchByID(String id){
        Node current = head;
        while (current != null){
            if (current.info.getID().equalsIgnoreCase(id)){
                return current.getData();
            }
            current = current.getNextNode();
        }
        return "No result";
    }

//    void deleteByID(String id){
//        Node current = head;
//        while (current != null){
//            if (current.info.getID().equalsIgnoreCase(id)){
//
//            }
//        }
//    }
}
