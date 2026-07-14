class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] numsRef = new int[nums.length][2];

        int i = 0;
        while(i < nums.length) {
            int j = i;
            while(j < nums.length) {
                if(nums[i] == nums[j]) { j++; }
                else { break; }
            }

            numsRef[i][0] = j-i;
            numsRef[i][1] = nums[i];

            i = j;
        }

        quickSort(numsRef, 0, nums.length-1);

        int[] sol = new int[k];
        int s = nums.length-k;
        while(s < nums.length) {
            sol[s - (nums.length-k)] = numsRef[s][1];
            s++;
        }

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
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;

        temp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = temp;
    }
}
