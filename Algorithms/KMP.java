public class KMP {
    public static void main(String[] args) {
        String str = "abcabdabc";
        String pattern = "abc";

        int[] lps = new int[pattern.length()];
        int j=0;
        lps[0]=0;
        for(int i=1; i<pattern.length(); i++){
            if(pattern.charAt(j) == pattern.charAt(i)){
                lps[i] = j+1;
                j++;
            } else {
                lps[i] = 0;
                j++;
            }
        }
        int i=0; j=0;
        while(i < str.length() && j < pattern.length()){
            if(str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else {
                if(j != 0){
                    j = lps[j];
                } else {
                    i++;
                }
            }
        }
        System.out.println((j == pattern.length()));
        for(Integer n : lps){
            System.out.print(n + " ");
        }    
    }
}

//Time Complexity is O(N)

/**
Idea of KMP evolves due to limitations of Naive Algorithm -> TC O(M*N)
We need to have a pre-computed pattern, based on prefix and suffix which is known as Longest Prefix as Suffix -> LPS
Then to iterate over the given string with LPS to know if pattern matches or not.
In case of mis-match, we need to move pattern iterator (in above case J ) to the indices of the LPS.
*/
