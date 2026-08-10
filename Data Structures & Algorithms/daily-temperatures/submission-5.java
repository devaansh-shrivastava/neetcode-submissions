class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //30,38,30,36,35,40,28
        //30, 0
        //pop, pop, 38, 1
        //30: (38, 30) (1, 2)
        //36: (38, 36) (1, 3)
        //35: (38, 36, 35) (1, 3, 4)
        //40, 5: pop: 

        List<int[]> list = new LinkedList<>();
        int i = 0;
        int l = temperatures.length;
        int[] result = new int[l];

        while(i < l) {
            while(!list.isEmpty()) {
                int[] arr = list.getFirst();
                if(arr[0] < temperatures[i]) {
                    list.removeFirst();
                    result[arr[1]] = i-arr[1];
                } else {
                    break;
                }                
            }

            int[] temp = new int[2];
            temp[0] = temperatures[i];
            temp[1] = i;
            list.addFirst(temp);
        
            i++;
        }

        return result;
    }
}