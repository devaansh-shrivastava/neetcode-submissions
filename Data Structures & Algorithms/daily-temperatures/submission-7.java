class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] stack = new int[n];  // pre-allocated, holds indices
        int top = -1;              // stack pointer

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return result;
    }
}