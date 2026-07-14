class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> charMap = new HashMap<>();

        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);

            charMap.computeIfAbsent(temp, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(charMap.values());
    }
}
