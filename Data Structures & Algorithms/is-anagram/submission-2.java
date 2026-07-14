class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) { return false; }

        int[] alpha = new int[26];
        int[] alpha_ref = new int[26];

        int i = 0;
        int l = s.length();

        while(i < l) {
            alpha[(int)(s.charAt(i) - 'a')]++;
            alpha[(int)(t.charAt(i) - 'a')]--;
            i++;
        }
        
        if(Arrays.equals(alpha, alpha_ref)) {return true;}
        return false;
    }
}
