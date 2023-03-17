import java.util.EmptyStackException;

class MyStack<T> {
    //Head node contains front node of the Stack
    Node top;
    /*
        To add new node to the front of the stack
        @param data: new element's information
     */
    void push(Product data){
        //create new node temp and allocate memory
        Node newNode = new Node(data);

        newNode.setNextNode(top);
        top = newNode;
    }

    /*
        to check if the stack is empty or not
     */
    boolean isEmpty(){
        return top == null;
    }

    /*
        return top element in the stack
        return the top node
     */
    Node peek() {
        //check for empty stack
        if (!isEmpty()) {
            return top;
        }
        else {
            throw new EmptyStackException();
        }
    }

    /*
        to pop top element from the stack
     */
    void pop(){
        //check for stack underflow
        if (top == null){
            System.out.println("Stack underflow");
            return;
        }

        //update the top pointer to point to the next node
        top = top.getNextNode();
    }

    /*
        to print the linked list
        @param top: the front node
     */
    void display(Node top){
        System.out.printf("%5s | %10s | %5s | %5s \n", "ID", "Title", "Quantity", "Price");
        System.out.println("-------------------------------------");
        while (top != null){
            System.out.println(top.getData());
            top = top.getNextNode();
        }
    }

    /*
        to clear existed product in current stack
     */
    public void clear() {
        while (top != null){
            top = top.getNextNode();
        }
    }
}
