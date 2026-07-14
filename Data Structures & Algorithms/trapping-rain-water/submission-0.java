class Solution {
    public int trap(int[] height) {
        if(height.length < 3) { return 0; } 
        
        int n = height.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for (int l = 0; l <= i; l++) leftMax = Math.max(leftMax, height[l]);
            for (int r = i; r < n; r++) rightMax = Math.max(rightMax, height[r]);
            total += Math.min(leftMax, rightMax) - height[i];
        }
        return total;
    }
}
