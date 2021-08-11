/* When Asked, look out for what output is expected.
for array output containing duplicate we can either go for HashMap or Sorting arrays and get the desired result
For unique element in output we need to think of Set. */

//For Duplicate
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            return intersection(nums2, nums1);
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for(Integer n : nums1){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        
        int i=0;
        for(Integer n : nums2){
            int cnt = count.getOrDefault(n, 0);
            if(cnt > 0){
                count.put(n, cnt-1);
                nums1[i++] = n;
            }
        }
        return Arrays.copyOfRange(nums1, 0, i);
    }
}
//Time Complexity is O(N+M)

//For unique
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(Integer n : nums1){
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n : nums2){
            set2.add(n);
        }
        if(set1.size() < set2.size()){
            return getIntersection(set1, set2);
        } else {
            return getIntersection(set2, set1);
        }
        
    }
    
    private int[] getIntersection(HashSet<Integer> set1, HashSet<Integer> set2){
        int[] result = new int[set1.size()];
        int index = 0;
        for(Integer n : set1){
            if(set2.contains(n)){
                result[index++] = n;
            }
        }
        return Arrays.copyOf(result, index);
    }
}

//Time Complexity O(N+M)
