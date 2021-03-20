class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> elements = new HashMap<>();
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            int count = elements.getOrDefault(nums[i], 0);
            elements.put(nums[i], count+1);
        }
        //Sort the Map Values by most frequest i.e most searched
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(elements.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] res = new int[k];
        int i =0;
        for(Map.Entry<Integer,Integer> entry : list){
            int key = entry.getKey();
            if(i<k){
                res[i++] = key;
            }
        }
        return res;
    }
}

//Time Complexity O(nLogN*k) and Space Complexity O(N+k);
//Runtime: 11 ms, faster than 49.71% of Java online submissions for Top K Frequent Elements.
//Memory Usage: 41.7 MB, less than 47.47% of Java online submissions for Top K Frequent Elements.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if(len == k){
            return nums;
        }
        HashMap<Integer, Integer> elements = new HashMap<>();
        for(Integer n : nums){
            elements.put(n, elements.getOrDefault(n, 0)+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)-> elements.get(n1) - elements.get(n2));
        int[] res = new int[k];
        for(Integer n : elements.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        for(int i=k-1; i>=0; i--){
            res[i] = heap.poll();
        }
        return res;
    }
}

//Runtime: 9 ms, faster than 86.02% of Java online submissions for Top K Frequent Elements.
//Memory Usage: 41.7 MB, less than 47.47% of Java online submissions for Top K Frequent Elements.
