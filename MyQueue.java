import javax.swing.*;

class MyQueue<T> {
    Node front;
    Node rear;

    /*
        to check if the queue is empty or not
        return true if the queue is empty
     */
    boolean isEmpty(){
        return (front == null);
    }

    /*
        to add new elements to the queue
        @param data: new element's information
     */
    void enqueue(Product data){
        //create new linked list node
        Node newNode = new Node(data);

        //if the queue is empty, then new node is front and rear both
        if (isEmpty()){
            front = rear = newNode;
        }
        //else add new node at the end and change rear
        else {
            rear.nextNode = newNode;
            rear = rear.nextNode;
        }
    }

    /*
        to remove element from queue
     */
    void dequeue(){
        //if the queue is empty, return null
        if (isEmpty()){
            return;
        }

        //store previous front and move front one node ahead
        Node temp = front;

        System.out.printf("%5s | %10s | %5s | %5s \n", "ID", "Title", "Quantity", "Price");
        System.out.println("-------------------------------------");
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.nextNode;
        }

        //if front becomes null, change rear also as null
        if (front == null){
            rear = null;
        }
    }

    void clear(){
        while (front != null){
            front = front.getNextNode();
        }
    }
}
