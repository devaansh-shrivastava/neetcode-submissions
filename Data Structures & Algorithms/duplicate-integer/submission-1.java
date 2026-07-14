class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> nums_count = new HashSet<>();

        int i = 0;
        while ( i < nums.length) {
            if(!nums_count.contains(nums[i])) { nums_count.add(nums[i]); }
            else { return true; }
            i++;
        }

        return false;
    }
}