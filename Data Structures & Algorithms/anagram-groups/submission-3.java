class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> charMap = new HashMap<>();

        for(String s: strs) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for (char ch : s.toCharArray()) count[ch - 'a']++;
// Build key: "1#0#1#0#..." — the # separator prevents "12" vs "1,2" collisions
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) sb.append(count[i]).append('#');
            String key = sb.toString();

            charMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(charMap.values());
    }
}
