package stackDs;

public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        System.out.println(largestAreaOfHistogram(new int[]{6, 2, 5, 4, 1, 5, 6}));
        System.out.println(largestAreaOfHistogramMoreEff(new int[]{6, 2, 5, 4, 1, 5, 6}));
        System.out.println(largestAreaOfHistogramMostEff(new int[]{6, 2, 5, 4, 1, 5, 6}));
    }

    public static int largestAreaOfHistogram(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i];
            for (int left = i - 1; left >= 0; left--) {
                if (arr[i] <= arr[left])
                    area += arr[i];
                else
                    break;
            }
            for (int right = i + 1; right < arr.length; right++) {
                if (arr[right] >= arr[i])
                    area += arr[i];
                else
                    break;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int largestAreaOfHistogramMoreEff(int[] arr) {
        int maxArea = 0;
        MyStack sp = new MyStack(arr.length);
        MyStack sn = new MyStack(arr.length);
        int[] smallestPrevious = new int[arr.length];
        int[] smallestNext = new int[arr.length];
        smallestNext[arr.length - 1] = arr.length;
        smallestPrevious[0] = -1;
        sp.push(0);
        sn.push(arr.length - 1);
        for (int i = 1; i < arr.length; i++) {
            while (!sp.isEmpty() && arr[sp.peek()] >= arr[i])
                sp.pop();
            smallestPrevious[i] = sp.isEmpty() ? -1 : sp.peek();
            sp.push(i);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!sn.isEmpty() && arr[sn.peek()] >= arr[i])
                sn.pop();
            smallestNext[i] = sn.isEmpty() ? arr.length : sn.peek();
            sn.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i];
            area += (i - smallestPrevious[i] - 1) * arr[i];
            area += (smallestNext[i] - i - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int largestAreaOfHistogramMostEff(int[] arr) {
        MyStack stack = new MyStack(arr.length);
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int peekItem = stack.peek();
                stack.pop();
                area = arr[peekItem] * (stack.isEmpty() ? i : i - stack.peek() - 1);
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
