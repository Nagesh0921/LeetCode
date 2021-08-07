class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        boolean isNegative = false;
        if(s1.charAt(0) == '-' && s2.charAt(0) == '-'){
            s2 = s2.substring(1);
            s1 = s1.substring(1);
        } else if(s2.charAt(0) == '-'){
            s2 = s2.substring(1);
            isNegative = true;
        } else if(s1.charAt(0) == '-'){
            s1 = s1.substring(1);
            isNegative = true;
        }
        
        
        
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        
        int l1 = chr1.length, l2 = chr2.length;
        char[] result = new char[l1+l2];
        Arrays.fill(result, '0');
        
        for(int j=l2-1; j>=0; j--){
            for(int i=l1-1; i>=0; i--){
                int product = (chr2[j] - '0') * (chr1[i] - '0');
                int temp = (result[j + i + 1] - '0') + product;
                
                result[j + i + 1] = (char)(temp % 10 + '0');
                result[j + i] = (char)(result[j + i] - '0' + (temp / 10 + '0'));
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isSeen = false;
        for(char c : result){
            if(!isSeen && c == '0'){
                continue;
            }
            sb.append(c);
            isSeen = true;
        }
        // System.out.println(isNegative);
        if(isNegative && sb.length() > 0){
            sb.insert(0,"-");
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}

//Time Coomplexity O(M * N)
