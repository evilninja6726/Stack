package stackDs;

import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        System.out.println(stockSpan(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30}));
        System.out.println(stockSpanEff(new int[]{14, 17, 12, 11, 7, 6, 19, 20, 21, 30}));
    }

    public static String stockSpan(int[] arr) {
        int[] stockSpan = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int c = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j] <= arr[i])
                    c++;
                else
                    break;
            }
            stockSpan[i] = c;
        }
        return Arrays.toString(stockSpan);
    }

    public static String stockSpanEff(int[] arr) {
        int[] stockSpan = new int[arr.length];
        MyStack stack = new MyStack(arr.length);
        stack.push(0);
        stockSpan[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();
            stockSpan[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return Arrays.toString(stockSpan);
    }
}
