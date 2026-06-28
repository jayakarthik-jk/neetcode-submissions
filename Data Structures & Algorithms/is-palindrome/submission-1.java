class Solution {
    private static final int OFFSET = 'a' - 'A';
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isValid(s.charAt(i))) { i++; }
            while (i < j && !isValid(s.charAt(j))) { j--; }
            if (i >= j) break;
            if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private static char toLowerCase(char ch) {
        if (isUpperCase(ch)) {
            return (char) (ch + OFFSET);
        }
        return ch;
    }

    private static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    private static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
    private static boolean isNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }
    
    public static boolean isValid(char ch) {
        if (isUpperCase(ch) || isLowerCase(ch) || isNumeric(ch)) {
            return true;
        }
        return false;
    }
}
