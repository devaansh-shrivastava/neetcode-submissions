class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }

        Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> s2 = new HashMap<>();

        int i = 0;
        while(i < s.length()) {
            char c1 = s.charAt(i);
            if(!s1.containsKey(c1)) {s1.put(c1, 1);}
            else {s1.put(c1, s1.get(c1)+1);}

            char c2 = t.charAt(i);
            if(!s2.containsKey(c2)) {s2.put(c2, 1);}
            else {s2.put(c2, s2.get(c2)+1);}
            
            i++;
        }

        if(s1.equals(s2)) {return true; }
        return false;
    }
}
