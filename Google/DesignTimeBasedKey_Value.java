class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Pair<Integer, String>>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        List<Pair<Integer, String>> p = map.get(key);
        int i = Collections.binarySearch(p, new Pair<Integer, String>(timestamp, "{"), 
                                        (a,b) -> Integer.compare(a.getKey(), b.getKey()));
        if(i >= 0){
            return p.get(i).getValue();
        } else if(i == -1){
            return "";
        } else {
            return p.get(-i-2).getValue();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
