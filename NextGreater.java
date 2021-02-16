package stackDs;

import java.util.Arrays;

public class NextGreater {
    public static void main(String[] args) {
        System.out.println(nextGreater(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30, 2, 1, 4}));
        System.out.println(nextGreaterEff(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30, 2, 1, 4}));
    }

    public static String nextGreater(int[] arr) {
        int[] nextGreater = new int[arr.length];
        nextGreater[arr.length - 1] = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    nextGreater[i] = -1;
                } else {
                    nextGreater[i] = arr[j];
                    break;
                }
            }
        }
        return Arrays.toString(nextGreater);
    }

    public static String nextGreaterEff(int[] arr) {
        int[] nextGreater = new int[arr.length];
        nextGreater[arr.length - 1] = -1;
        MyStack stack = new MyStack(arr.length);
        stack.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return Arrays.toString(nextGreater);
    }
}
