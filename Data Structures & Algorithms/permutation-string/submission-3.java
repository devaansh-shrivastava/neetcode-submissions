class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) { return false; }
        
        int i = 0;
        int[] refMap = new int[26];
        int[] dynMap = new int[26];
        while(i < s1.length()) {
            refMap[s1.charAt(i) - 'a']++;
            dynMap[s2.charAt(i) - 'a']++;
            i++;
        }
        if(Arrays.equals(refMap, dynMap)) { return true; }

        i = s1.length();
        while(i < s2.length()) {
            dynMap[s2.charAt(i-s1.length()) - 'a']--;
            dynMap[s2.charAt(i) - 'a']++;

            if(Arrays.equals(refMap, dynMap)) { return true; }
            i++;
        }

        return false; 

    }
}
