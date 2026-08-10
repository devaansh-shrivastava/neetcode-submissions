class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) { return false; }
        
        int i = 0;
        int[] refMap = new int[26];
        int[] dynMap = new int[26];

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        while(i < s1.length()) {
            refMap[c1[i] - 'a']++;
            dynMap[c2[i] - 'a']++;
            i++;
        }
        if(Arrays.equals(refMap, dynMap)) { return true; }

        i = s1.length();
        while(i < s2.length()) {
            dynMap[c2[i-s1.length()] - 'a']--;
            dynMap[c2[i] - 'a']++;

            if(Arrays.equals(refMap, dynMap)) { return true; }
            i++;
        }

        return false; 

    }
}
