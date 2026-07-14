class Solution {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        String f = sl.replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = f.length()-1;

        char[] c = f.toCharArray();

        while(i < j) {
            if(c[i] != c[j]) { return false; }
            i++; j--;
        }

        return true;
    }
}
