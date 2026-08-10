class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        List<int[]> stack = new LinkedList<>();
        int l = temperatures.length;
        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            while (!stack.isEmpty() && stack.getFirst()[0] < temperatures[i]) {
                int[] popped = stack.removeFirst();
                result[popped[1]] = i - popped[1];
            }
            stack.addFirst(new int[]{temperatures[i], i});
        }
        // Anything left in stack never found a warmer day — result[] defaults to 0 already, no need to loop
        return result;
    }
}