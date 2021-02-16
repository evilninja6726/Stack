package stackDs;

import java.util.Arrays;

public class PreviousGreater {
    public static void main(String[] args) {
        System.out.println(previousGreater(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30, 2, 1, 4}));
        System.out.println(previousGreaterEff(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30, 2, 1, 4}));
    }

    public static String previousGreater(int[] arr) {
        int[] previousGreater = new int[arr.length];
        previousGreater[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    previousGreater[i] = arr[j];
                    break;
                } else
                    previousGreater[i] = -1;
            }
        }
        return Arrays.toString(previousGreater);
    }

    public static String previousGreaterEff(int[] arr) {
        MyStack stack = new MyStack(arr.length);
        int[] previousGreater = new int[arr.length];
        previousGreater[0] = -1;
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            previousGreater[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return Arrays.toString(previousGreater);
    }
}
