class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1) { return 1; }
         
        int fleet = 1;

        quickSort(position, speed, 0, position.length-1);

        int i = position.length-1;
        double maxTimeSoFar = (double)(target-position[i])/speed[i];

        i--;
        while(i >= 0) {
            double time_behind_i = (double)(target-position[i])/speed[i];

            if(time_behind_i > maxTimeSoFar) { 
                fleet++;
                maxTimeSoFar = (double)(target-position[i])/speed[i]; 
            }

            i--;
        }

        return fleet;
    }

    public void quickSort(int[] arr, int[] arr2, int low, int high) {
        if (low < high) {
            // partitionIndex is the correct final index of the pivot
            int partitionIndex = partition(arr, arr2, low, high);

            // Recursively sort elements before and after the partition index
            quickSort(arr, arr2, low, partitionIndex - 1);
            quickSort(arr, arr2, partitionIndex + 1, high);
        }
    }

    // Method to partition the array based on the pivot element
    private int partition(int[] arr, int[] arr2, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];
        
        // Pointer for the greater element element
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, arr2, i, j);
            }
        }

        // Swap the pivot element with the greater element specified by i
        swap(arr, arr2, i + 1, high);
        
        // Return the fixed position of the pivot
        return i + 1;
    }

    // Helper method to swap two elements in an array
    private void swap(int[] arr, int[] arr2, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        temp = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp;
    }
}
