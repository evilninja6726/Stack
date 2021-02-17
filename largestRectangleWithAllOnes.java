package stackDs;

public class largestRectangleWithAllOnes {
    public static void main(String[] args) {
        int R = 4;
        int C = 4;
        int A[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.println(largestAreaWithAllOnes(A));
    }

    public static int largestAreaWithAllOnes(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int maxArea = largestArea(arr[0]);
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i - 1][j] != 0)
                    arr[i][j] += arr[i - 1][j];
            }
            maxArea = Math.max(maxArea, largestArea(arr[i]));
        }
        return maxArea;
    }

    public static int largestArea(int[] arr) {
        MyStack stack = new MyStack(arr.length);
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int peekItem = stack.peek();
                stack.pop();
                area = arr[peekItem] * (stack.isEmpty() ? -1 : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int peekItem = stack.peek();
            stack.pop();
            area = arr[peekItem] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
