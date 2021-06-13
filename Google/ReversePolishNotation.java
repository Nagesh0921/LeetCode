class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        
        for(String token : tokens){
            if(!"+-*/".contains(token)){
                values.push(Integer.valueOf(token));    
                continue;
            }
            int val2 = values.pop();
            int val1 = values.pop();
            
            int result = 0;
            
            switch(token){
                case "+" : result = val1 + val2;
                    break;
                case "-" : result = val1 - val2;
                    break;
                case "/" : if(val2 != 0) {
                    result = val1 / val2;
                }
                    break;
                case "*" : result = val1 * val2;
                    break;
            }
            
            values.push(result);
        }
        
        return values.pop();
    }
}

//Example
// 6 -12 * 2 7 - / 7 +
//Infix notation : 3+4 we will use BODMAS but in computer language
//Which is do division or multiplication first (from left to right)
//do addition or subtraction later (from left to right)
//In School maths, BODMAS is different -> Division -> Multiplication -> Addition -> Subtraction
//Reverse Polish Notation is an example of that
//We can do it using list/array using in place replacement
//but manipulating array in place is something tedious in java
//hence we can stack
