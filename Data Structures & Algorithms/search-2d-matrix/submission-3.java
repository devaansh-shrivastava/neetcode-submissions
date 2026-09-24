class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0]) { return false; }
        if(target > matrix[matrix.length-1][matrix[0].length-1]) { return false; }
        
        //binary search with %
        //target = 10
        //1 2 4 8 | 10 11 12 13 | 24 20 30 40
        //bi(0,11): 5: 5/4 = 1: row[1] + 1st index
        //11 > 10: bi(0,4): 2
        //4 < 10: bi(3,4): 3
        //8 < 10: bi(4,4): 4
        //10 = 10

        return binary(matrix, target, 0, matrix.length*matrix[0].length - 1);
    }
    public boolean binary(int[][] arr, int t, int l, int h) {
        if(l < 0 || h >= arr.length*arr[0].length || l > h) { return false; }
        if(l == h) {
            if(t == arr[l/arr[0].length][l%arr[0].length]) { return true; }
            else { return false; }
        }

        int m = l + (h-l)/2;
        int r = m/arr[0].length;
        int c = m%arr[0].length;

        if(t == arr[r][c]) { return true; }
        else if (t < arr[r][c]) { return binary(arr, t, l, m-1); }
        else { return binary(arr, t, m+1, h); }
    }
}
