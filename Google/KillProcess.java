class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> parentIdToChildren = new HashMap<>();
        for(int i=0; i<ppid.size(); i++){
            if(ppid.get(i) > 0){
                List<Integer> inner = parentIdToChildren.getOrDefault(parentIdToChildren.get(ppid.get(i)), new ArrayList<Integer>());
                inner.add(pid.get(i));
                parentIdToChildren.put(ppid.get(i), inner);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(kill);
        killAllChildProcess(result, parentIdToChildren, kill);
        return result;
    }
    
    private void killAllChildProcess(List<Integer> result, HashMap<Integer, List<Integer>> map, int kill){
        if(map.containsKey(kill)){
            for(int n : map.get(kill)){
                result.add(n);
                killAllChildProcess(result, map, n);
            }
        }    
    }
}

//Time Complexity is O(N) and Space Complexity is O(N)
