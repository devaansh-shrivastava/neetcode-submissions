class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int prodWithout0 = 1;

        boolean multiple0s = false;

        int i = 0;
        while(i < nums.length) {
            if(nums[i] == 0 && multiple0s) { Arrays.fill(nums, 0); return nums; }
            else if(nums[i] == 0) { prod = 0; multiple0s = true; }
            else { prodWithout0 *= nums[i]; }
            
            i++;
        }

        System.out.println(prod + " " + prodWithout0);

        i=0;
        while(i < nums.length) {
            if(multiple0s) { 
                if(nums[i] == 0) { nums[i] = prodWithout0; }
                else { nums[i] = 0; }
            }
            else { nums[i] = prodWithout0/nums[i]; }

            i++;
        }

        return nums;
    } 
}  
