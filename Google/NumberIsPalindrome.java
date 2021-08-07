class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        char[] chars = ("" + n).toCharArray();
        if(chars.length <= 1){
            return "Yes";
        }
        int len = chars.length;
        boolean isPalindrome = false;
        for(int i=0, j=len-1; i<j; i++, j--){
            if(chars[i] == chars[j]){
                isPalindrome = true;
                continue;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome ? "Yes" : "No";
    }
}

//Time Complexity O(n)
