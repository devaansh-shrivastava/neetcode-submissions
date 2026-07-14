class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;

        int minH = 0;
        int maxA = 0;
        while(j-i >= 1) {
            minH = Math.min(heights[i], heights[j]);
            maxA = Math.max(minH*(j-i), maxA);
            if(minH == heights[i]) {i++;}
            else {j--;}
        }

        return maxA;
    }
}
