class Solution {
    public double myPow(double x, int n) {
        long res = n;
        if(res < 0){
            x = 1/x;
            res = -res;
        }
        return recurse(x, res);
    }
    
    private double recurse(double x, long n){
        if(n == 0){
            return 1.0;
        }
        //recurse
        double half = recurse(x, n/2);
        if(n % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
