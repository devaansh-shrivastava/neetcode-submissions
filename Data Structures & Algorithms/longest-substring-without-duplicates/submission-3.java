class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) { return 0; }

        Map<Character, Integer> charMap = new HashMap<>();
        char[] c = s.toCharArray();

        int i = 0;
        int j = 0;
        int max = 0;
        int l = c.length;
        while(j < l) {
            if(charMap.containsKey(c[j])) {
                i = Math.max(i, charMap.get(c[j]) +1);
                charMap.put(c[j], j);
            } else {
                charMap.put(c[j], j);
            }

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }
}
