class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> nums_count = new HashMap<>();

        int i = 0;
        while (i < nums.length) {
            if(!nums_count.containsKey(nums[i])) { nums_count.put(nums[i], 1); }
            else { return true; }
            i++;
        }

        return false;
    }
}