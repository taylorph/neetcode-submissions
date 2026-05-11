class Solution {
    public boolean isPalindrome(String s) {
        // this will store only the valid characters:
        // - letters AND numbers, all converted to lowercase.
        String newStr = "";

        // loop through every character in the original string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // only keep the letters and numbers.
            // ignores any spaces, commas, colons, punctuation, etc
            if (Character.isLetterOrDigit(c)) {
                newStr += Character.toLowerCase(c);
            }
        }

        // compares the cleaned string with its reversed version
        // if they are the same, then it is a palindrome
        String reversed = "";
        
        for (int i = newStr.length() - 1; i >= 0; i--) {
            reversed += newStr.charAt(i);
        }

        return newStr.equals(reversed);
    }
}