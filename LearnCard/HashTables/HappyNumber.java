class Solution {
    public boolean isHappy(int n) {
        //Assuming Constraint, we need not have to worry about case 0.
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int remainder = n % 10;
            n = n / 10;
            totalSum += remainder*remainder;
        }
        return totalSum;
    }
}

//Time Complexity O(log N)
//Reason: as we know that, for 3 digit number, it is impossible to beyond 243 number.
/*
That 3rd option sounds really annoying to detect and handle. How would we even know that it is going to continue going up, rather than eventually going back down, possibly to 1?1? Luckily, it turns out we don't need to worry about it. Think carefully about what the largest next number we could get for each number of digits is.

Digits	Largest	Next
1	9	81
2	99	162
3	999	243
4	9999	324
13	9999999999999	1053
*/
