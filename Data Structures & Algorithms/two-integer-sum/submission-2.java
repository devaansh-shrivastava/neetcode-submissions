class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        int[][] numref = new int[l][2];
        int[] sol = new int[2];

        int i = 0;
        while(i<l) {
            numref[i][0] = nums[i];
            numref[i][1] = i;
            i++;
        }

        quickSort(numref, 0, l-1);
        // for(int[] n: numref) {
        //     System.out.println(n[1] + " : " + n[0]);
        // }

        i = 0;
        int j = l-1;
        while(i < j) {
            int ref = numref[i][0] + numref[j][0];
            if(target == ref) { sol[0] = numref[i][1]; sol[1] = numref[j][1]; break; }
            else if(target > ref) { i++; }
            else { j--; }
        }

        // for(int s: sol) {
        //     System.out.println(s);
        // }
        Arrays.sort(sol);
        return sol;
    }
    // Recursive method that handles the sorting logic
    public static void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            // partitionIndex is the correct final index of the pivot
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before and after the partition index
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Method to partition the array based on the pivot element
    private static int partition(int[][] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high][0];
        
        // Pointer for the greater element element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j][0] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the greater element specified by i
        swap(arr, i + 1, high);
        
        // Return the fixed position of the pivot
        return i + 1;
    }

    // Helper method to swap two elements in an array
    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][0];
        int tempPos = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = temp;
        arr[j][1] = tempPos;
    }
}
