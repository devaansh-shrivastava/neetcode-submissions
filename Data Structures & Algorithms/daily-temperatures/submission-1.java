class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //30,38,30,36,35,40,28
        //30, 0
        //pop, pop, 38, 1
        //30: (38, 30) (1, 2)
        //36: (38, 36) (1, 3)
        //35: (38, 36, 35) (1, 3, 4)
        //40, 5: pop: 

        List<Integer> list = new LinkedList<>();
        List<Integer> listIndex = new LinkedList<>();
        int i = 0;
        int l = temperatures.length;
        int[] result = new int[l];

        while(i < l) {
            while(list.size() > 0 && list.getFirst() < temperatures[i]) {
                list.removeFirst();
                int ll = listIndex.removeFirst();
                result[ll] = i-ll;
            }
            list.addFirst(temperatures[i]);
            listIndex.addFirst(i);
        
            i++;
        }

        while(list.size() != 0) {
            int ll = listIndex.getFirst();
            result[ll] = 0;
            list.removeFirst();
            listIndex.removeFirst();
        }

        return result;
    }
}