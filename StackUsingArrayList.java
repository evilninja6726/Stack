package stackDs;

import java.util.ArrayList;

public class StackUsingArrayList {
    public static void main(String[] args) {
        MyStackAl myStack = new MyStackAl();
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

class MyStackAl {
    ArrayList<Integer> arrayList;

    MyStackAl() {
        arrayList = new ArrayList<>();
    }

    void push(int data) {
        arrayList.add(data);
    }

    int pop() {
        if (arrayList.isEmpty()) {
            System.out.println("Stack is Already Empty, Can\'t perform Action.");
            return Integer.MIN_VALUE;
        }
        arrayList.remove(arrayList.size() - 1);
        return arrayList.get(arrayList.size() - 1);
    }

    int peek() {
        if (arrayList.isEmpty()) {
            System.out.println("No Peak, Stack is Empty.");
            return Integer.MIN_VALUE;
        }
        return arrayList.get(arrayList.size() - 1);
    }

    int size() {
        return arrayList.size();
    }

    boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
