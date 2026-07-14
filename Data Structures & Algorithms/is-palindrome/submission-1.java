class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toCharArray();

        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(c[i])) {i++;}
            while(i < j && !Character.isLetterOrDigit(c[j])) {j--;}

            if(Character.toLowerCase(c[i]) == Character.toLowerCase(c[j])) { i++; j--;}
            else { return false; }
        }

        return true;
    }
}
