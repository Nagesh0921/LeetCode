class Solution {
    public int numTrees(int n) {
        //catalan number
        //Maths: 2(2n+1)/(n+2) * (Prev Catalan value), catalan value of 1 = 1
        //Also known as Combinatronics mathematics
        //useful in finding numer of valid paranthesis
        long c = 1;
        for(int i=1; i<n; i++){
            c = c * 2 * (2 * i + 1)/(i + 2);
        }
        return (int) c;
    }
}

//Time Complexity O(N)
