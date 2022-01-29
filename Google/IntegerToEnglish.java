class Solution {
    StringBuilder sb = new StringBuilder();
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        
        int billion = num/1000000000;
        int million = (num - billion*1000000000)/1000000;
        int thousand = (num - billion*1000000000 - million*1000000)/1000;
        int rest = num - billion*1000000000 - million*1000000 - thousand*1000;
        
        if(billion != 0){
            sb.append(hundredIndex(billion)).append(" Billion ");
        }
        if(million != 0){
            sb.append(hundredIndex(million)).append(" Million ");
        }
        if(thousand != 0){
            sb.append(hundredIndex(thousand)).append(" Thousand ");
        }
        if(rest != 0){
            sb.append(hundredIndex(rest));
        }
        
        return sb.toString().trim();
    }
    
    private String hundredIndex(int num){
        int hundred = num/100;
        int rest = num - hundred*100;
        StringBuilder sb = new StringBuilder();
        if(hundred*rest != 0){
            sb.append(firstIndex(hundred)).append(" Hundred ").append(tenthIndex(rest));
        } else if(hundred == 0 && rest != 0){
            sb.append(tenthIndex(rest));
        } else if(hundred != 0 && rest == 0){
            sb.append(firstIndex(hundred)).append(" Hundred");
        }
        return sb.toString();
    }
    
    private String tenthIndex(int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return "";
        } else if(num < 10){
            sb.append(firstIndex(num));
        } else if(num < 20){
            sb.append(secondIndex(num));
        } else {
            int ten = num/10;
            int rest = num - ten*10;
            if(rest != 0){
                sb.append(hundredPlace(ten)).append(" ").append(firstIndex(rest));
            } else {
                sb.append(hundredPlace(ten));
            }
        }
        return sb.toString();
    }
    
    private String firstIndex(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    
    private String secondIndex(int num){
        switch(num){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    
    private String hundredPlace(int num){
        switch(num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
}
