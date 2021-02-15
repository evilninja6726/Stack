package stackDs;

import java.util.ArrayDeque;

public class StackUsingCollection {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        System.out.println(arrayDeque.isEmpty());
        arrayDeque.push(10);
        arrayDeque.push(20);
        arrayDeque.push(30);
        arrayDeque.push(40);
        arrayDeque.push(50);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.size());
        System.out.println(arrayDeque.peek());
    }
}
