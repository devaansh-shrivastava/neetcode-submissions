class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int idx, int currentXor) {
        // base case: all decisions made, this path is one complete subset
        if (idx == nums.length) {
            return currentXor;
        }
        // choice 1: include nums[idx]
        int take = dfs(nums, idx + 1, currentXor ^ nums[idx]);
        // choice 2: skip nums[idx]
        int skip = dfs(nums, idx + 1, currentXor);

        return take + skip;
    }
}