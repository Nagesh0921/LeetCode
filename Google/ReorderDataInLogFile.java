class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> customComparator = new Comparator<String>(){
            @Override
            public int compare(String log1, String log2){
                String[] str1 = log1.split(" ", 2);
                String[] str2 = log2.split(" ", 2);
                
                //Check if initial letter has Digit
                boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2){
                    int comp = str1[1].compareTo(str2[1]);
                    if(comp != 0){
                        return comp;
                    }
                    
                    return str1[0].compareTo(str2[0]);
                }
                
                if(!isDigit1 && isDigit2){
                    return -1;
                } else if(isDigit1 && !isDigit2){
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, customComparator);
        return logs;
    }
}
