class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        if(n == 1){
            return arr[0];
        }
        // code here
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        // System.out.println(map);
        int frequency = 0;
        String str = "";
        for(String s : map.keySet()){
            // System.out.println(s);
            if(map.get(s) >= frequency){
                frequency = map.get(s);
                str = s;
            }
        }
        return str;
    }

}

//Time Complexity O(N)
