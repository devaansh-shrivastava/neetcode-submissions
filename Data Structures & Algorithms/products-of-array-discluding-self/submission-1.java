class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;

        int i = 0;
        while (i<nums.length) {
            if(nums[i] == 0) { zeroCount++; }
            else { product*=nums[i]; }
            i++;
        }

        if(zeroCount == 0) {
            i = 0;
            while (i<nums.length) {
                nums[i] = (int)product/nums[i];
                i++;
            }
        }
        else if(zeroCount == 1) {
            i = 0;
            while (i<nums.length) {
                if(nums[i] == 0) { nums[i] = (int)product; }
                else { nums[i] = 0; }
                i++;
            }
        }
        else {
            Arrays.fill(nums, 0);
        }

        return nums;
    } 
}  
