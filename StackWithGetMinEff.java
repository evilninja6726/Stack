package stackDs;

public class StackWithGetMinEff {
    public static void main(String[] args) {
        MyStackWithGetMinEff myStack = new MyStackWithGetMinEff();
        myStack.pushForPositive(4);
        myStack.pushForPositive(5);
        myStack.pushForPositive(8);
        myStack.pushForPositive(1);
        myStack.popForPositive();
        System.out.println(myStack.peekForPositive());

        System.out.print(" Minimum Element from Stack: " + myStack.getMin());
        System.out.println();
        System.out.println("************************************************************************");

        MyStackWithGetMinEff myStack2 = new MyStackWithGetMinEff();
        myStack2.push(4);
        myStack2.push(5);
        myStack2.push(8);
        myStack2.push(1);
        myStack2.pop();
        System.out.println(myStack2.peek());

        System.out.print(" Minimum Element from Stack: " + myStack2.getMin());

    }
}

class MyStackWithGetMinEff {
    int min;
    Node head;

    MyStackWithGetMinEff() {
        min = Integer.MAX_VALUE;
        head = null;
    }

    void pushForPositive(int data) {
        Node pushedItem;
        if (head == null)
            min = data;
        if (min >= data) {
            pushedItem = new Node(data - min);
            min = data;
        } else {
            pushedItem = new Node(data);
        }
        pushedItem.next = head;
        head = pushedItem;
    }

    int popForPositive() {
        if (head == null) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = head.data;
        if (poppedItem <= 0) {
            int res = min;
            min = min - poppedItem;
            head = head.next;
            return res;
        } else {
            head = head.next;
            return poppedItem;
        }
    }

    int peekForPositive() {
        if (head == null) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        if (head.data <= 0) {
            return min;
        }
        return head.data;
    }

    int getMin() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return min;
    }

    void push(int data) {
        Node pushedItem;
        if (head == null)
            min = data;
        if (min >= data) {
            pushedItem = new Node(2 * data - min);
            min = data;
        } else {
            pushedItem = new Node(data);
        }
        pushedItem.next = head;
        head = pushedItem;
    }

    int pop() {
        if (head == null) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = head.data;
        if (poppedItem <= min) {
            int res = min;
            min = 2 * min - poppedItem;
            head = head.next;
            return res;
        } else {
            head = head.next;
            return poppedItem;
        }
    }

    int peek() {
        if (head == null) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        if (head.data <= min) {
            return min;
        }
        return head.data;
    }
}
