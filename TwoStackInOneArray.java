package stackDs;

public class TwoStackInOneArray {
    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack(5);
        twoStack.pop1();
        twoStack.push1(10);
        twoStack.push1(20);
        twoStack.push1(30);
        twoStack.push1(40);
        twoStack.push2(20);
        twoStack.push2(30);

        System.out.println();
        TwoStackEff twoStackEff = new TwoStackEff(5);
        twoStackEff.pop1();
        twoStackEff.push1(10);
        twoStackEff.push1(20);
        twoStackEff.push1(30);
        twoStackEff.push1(40);
        twoStackEff.push2(20);
        twoStackEff.push2(30);
    }
}

class TwoStack {
    int capacity, top1, top2;
    int[] arr;

    TwoStack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        top1 = (capacity / 2) + 1;
        top2 = capacity / 2;
    }

    void push1(int data) {
        if (top1 > 0) {
            arr[--top1] = data;
        } else {
            System.out.println("Stack Overflow.");
            return;
        }
    }

    void push2(int data) {
        if (top2 < capacity - 1) {
            arr[++top2] = data;
        } else {
            System.out.println("Stack Overflow.");
            return;
        }
    }

    int pop1() {
        if (top1 == (capacity / 2) + 1) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = arr[top1++];
        return poppedItem;
    }

    int pop2() {
        if (top2 == capacity / 2) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        }
        int poppedItem = arr[top2--];
        return poppedItem;
    }
}

class TwoStackEff {
    int capacity, top1, top2;
    int[] arr;

    TwoStackEff(int capacity) {
        this.capacity = capacity;
        top1 = -1;
        top2 = capacity;
        arr = new int[capacity];
    }

    void push1(int data) {
        if (top1 < top2 - 1) {
            arr[++top1] = data;
        } else {
            System.out.println("Stack Overflow.");
            return;
        }
    }

    void push2(int data) {
        if (top1 < top2 - 1) {
            arr[--top2] = data;
        } else {
            System.out.println("Stack Overflow.");
        }
    }

    int pop1() {
        if (top1 == -1) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        } else {
            int poppedItem = arr[top1--];
            return poppedItem;
        }
    }

    int pop2() {
        if (top2 == capacity) {
            System.out.println("Stack Underflow.");
            return Integer.MIN_VALUE;
        } else {
            int poppedItem = arr[top2++];
            return poppedItem;
        }
    }
}