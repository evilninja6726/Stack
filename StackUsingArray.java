package stackDs;

public class StackUsingArray {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
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
    }
}

class MyStack {
    private int[] arr;
    private int top;
    private int capacity;

    MyStack(int capacity) {
        top = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack if Full so can\'t add more items.");
        } else {
            top++;
            arr[top] = data;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack is Already Empty, Can\'t perform Action.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = arr[top];
        top--;
        return poppedItem;
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        if (top == -1) {
            System.out.println("No Peak, Stack is Empty.");
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }
}

