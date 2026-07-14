class Solution {
    public int trap(int[] height) {
        if(height.length < 3) { return 0; } 
        
        int l = height.length;
        int total = 0;

        int[] leftMax = new int[l];
        int[] rightMax = new int[l];
        
        int i = 0;
        while(i < l) {

            if(i == 0) { leftMax[i] = height[i]; }
            else{ leftMax[i] = Math.max(height[i], leftMax[i-1]); }
            
            if(i == 0) { rightMax[l-1-i] = height[l-1-i]; } 
            else { rightMax[l-1-i] = Math.max(height[l-1-i], rightMax[l-i]); }

            i++;
        }

        i = 0;
        while(i < l) { 
            total += Math.min(leftMax[i], rightMax[i]) - height[i]; 
            i++;
        }

        return total;
    }
}
