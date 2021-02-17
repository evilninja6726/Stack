package stackDs;

import java.util.Stack;

public class StackWithGetMin {
    public static void main(String[] args) {
        MyStackWithGetMin myStack = new MyStackWithGetMin();
        myStack.pop();
        myStack.peek();
        myStack.push(10);
        System.out.println(myStack.size());
        myStack.push(20);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.push(30);
        System.out.println(myStack.getMin());
        myStack.push(5);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        System.out.println(myStack.size());
        myStack.pop();
        System.out.println(myStack.peek());
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        System.out.println(myStack.size());
    }
}

class MyStackWithGetMin {
    Node head;
    int size;
    Stack<Integer> stackWithGetMin;

    MyStackWithGetMin() {
        size = 0;
        head = null;
        stackWithGetMin = new Stack<>();
    }

    void push(int data) {
        Node pushedItem = new Node(data);
        if (head == null)
            stackWithGetMin.push(pushedItem.data);
        if (pushedItem.data < stackWithGetMin.peek())
            stackWithGetMin.push(pushedItem.data);
        pushedItem.next = head;
        head = pushedItem;
        size++;
    }

    int pop() {
        if (head == null) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = head.data;
        if (poppedItem == stackWithGetMin.peek())
            stackWithGetMin.pop();
        head = head.next;
        size--;
        return poppedItem;
    }

    int peek() {
        if (head == null) {
            System.out.println("No peek, Stack is Empty.");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    int size() {
        return size;
    }

    int getMin() {
        if (head==null){
            System.out.println("No Min, Stack is Empty.");
            return Integer.MIN_VALUE;
        }
        return stackWithGetMin.peek();
    }
}
