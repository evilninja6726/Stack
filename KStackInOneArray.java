package stackDs;

import java.util.Arrays;

public class KStackInOneArray {
    public static void main(String[] args) {
        int k = 3, n = 10;

        KStack ks = new KStack(n, k);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}

class KStack {
    private int capacity, freeTop, stackNumber;
    private int[] next;
    private int[] top;
    private int[] arr;

    KStack(int capacity, int stackNumber) {
        this.capacity = capacity;
        this.stackNumber = stackNumber;
        freeTop = 0;
        next = new int[capacity];
        top = new int[stackNumber];
        arr = new int[capacity];
        Arrays.fill(top, -1);
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
    }

    void push(int data, int stackNumber) {
        if (freeTop == -1) {
            System.out.println("Stack Overflow");
            return;
        }
        int i = freeTop;    //set a variable i of getting the free top available
        freeTop = next[i]; // update the next free top from next array as next array gives the next free index
        next[i] = top[stackNumber];  //update the next array, since it also tells the previous top of stack
        top[stackNumber] = i;  //update top as current index of item that is i
        arr[i] = data;  //putting the data in array
    }

    int pop(int stackNumber) {
        if (top[stackNumber] == -1) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int i = top[stackNumber];  //set a variable i for getting the index at which is top of current stack is
        top[stackNumber] = next[i]; //top of stack can be updated by next array as next array contains the previous top of current array
        next[i] = freeTop; // we will set the next[i] as which is next free top available
        freeTop = i; //update the free top as which is now available, it simply tells the current top value's index
        return arr[i];
    }

}