class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int l = strs.length;
        HashMap<String, List<String>> charMap = new HashMap<>();

        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);

            if(charMap.containsKey(temp)) {
                List<String> tempList = charMap.get(temp);
                tempList.add(s);
                charMap.put(temp, tempList);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                charMap.put(temp, tempList);
            }
        }

        Set<String> charMapSet = charMap.keySet();
        List<List<String>> sol = new ArrayList<>();
        for(String cms: charMapSet) {
            sol.add(charMap.get(cms));
        }

        return sol;
    }
}
