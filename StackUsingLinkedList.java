package stackDs;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        MyStackLl myStack = new MyStackLl();
        System.out.println(myStack.isEmpty());
        myStack.pop();
        myStack.peek();
        myStack.push(10);
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.size());
        myStack.pop();
        System.out.println(myStack.peek());
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        System.out.println(myStack.size());
    }
}

class MyStackLl{
    private int size;
    private Node head;
    MyStackLl(){
        this.size =0;
        head=null;
    }

    void push(int data){
        size++;
        Node pushedNode=new Node(data);
        pushedNode.next=head;
        head=pushedNode;
    }
    int pop(){
        if (head==null){
            System.out.println("Stack is Already Empty");
            return Integer.MIN_VALUE;
        }
        size--;
        int poppedNode=head.data;
        head=head.next;
        return poppedNode;
    }
    int peek(){
        if (head==null){
            System.out.println("No Peak, Stack is Empty.");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return head==null;
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}