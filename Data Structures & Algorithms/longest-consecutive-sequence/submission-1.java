class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {return 0;}

        Arrays.sort(nums);
        int maxtemp = 1;
        int max = 1;

        int i = 1;
        while(i < nums.length) {
            if(nums[i] - nums[i-1] <= 1) { 
                maxtemp+=(nums[i] - nums[i-1]); 
                max = Math.max(max, maxtemp);
            }
            else {maxtemp = 1;}
            i++;
        }

        return max;
    }
}
