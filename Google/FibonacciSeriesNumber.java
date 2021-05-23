class Solution {
    public int fib(int n) {
        // if(n <= 1){
        //     return n;
        // }
        // return fib(n-1) + fib(n-2);
        // return memoize(n);
        double goldenRatio = (1 + Math.sqrt(5))/2;
        return (int) Math.round(Math.pow(goldenRatio, n)/Math.sqrt(5));
    }
    
    private int memoize(int n){
        int[] cache = new int[n+1];
        cache[1]=1;
        for(int i=2; i<=n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
}

//Time Complexities: first recurssion: 2^N, memoization O(N), formula based O(1)
