class Solution {
    public boolean isPalindrome(String s) {
        s = s.chars()
            .filter(Character::isLetterOrDigit)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString()
            .toUpperCase();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.println(s.charAt(i) + " " + s.charAt(s.length() - i - 1));
                return false;
            }
        }
        return true;
    }
}
