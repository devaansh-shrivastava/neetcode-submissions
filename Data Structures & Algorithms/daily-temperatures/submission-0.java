class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) { int[] result = new int[1]; return result; }

        int l = temperatures.length;
        int[] result = new int[l];
        int[] diff = new int[l];

        int i = 0;
        while(i < l-1) {
            diff[i] = temperatures[i+1] - temperatures[i];
            i++;
        }
        diff[i] = 0;

        i = 0;
        while(i < l) {
            if(diff[i] > 0) { result[i] = 1; }
            else {
                int j = i;
                int sum = 0;
                while(j < l && sum <= 0) {
                    sum += diff[j];
                    j++;
                }

                if(j == l) { result[i] = 0; }
                else { result[i] = (j-i); }
            }

            i++;
        }

        return result;
    }
}
