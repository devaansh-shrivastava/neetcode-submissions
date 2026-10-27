class Solution {
    public int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;

        int i = 0;
        while(i < grid.length) {
            int j = 0;
            while(j < grid[0].length) {
                if(grid[i][j] == 1) {
                    totalPerimeter += perimeter(grid, i, j);
                }
                j++;
            }
            i++;
        }

        return totalPerimeter;
    }
    private int perimeter(int[][] grid, int i, int j) {
        int sum = 0;

        if(i-1 >= 0 && grid[i-1][j] == 1) { sum += 1; }
        if(i+1 < grid.length && grid[i+1][j] == 1) { sum += 1; }
        if(j-1 >= 0 && grid[i][j-1] == 1) { sum += 1; }
        if(j+1 < grid[0].length && grid[i][j+1] == 1) { sum += 1; }

        return 4-sum;
    }
}