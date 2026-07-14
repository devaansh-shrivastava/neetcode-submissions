class Solution {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        String f = sl.replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = f.length()-1;

        while(i < j) {
            if(f.charAt(i) != f.charAt(j)) { return false; }
            i++; j--;
        }

        return true;
    }
}
