class RandomizedSet {

    HashMap<Integer, Integer> indexMap;
    ArrayList<Integer> list;
    Random r = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        indexMap = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        indexMap.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int lastElement = list.get(list.size()-1);
        int index = indexMap.get(val);
        list.set(index, lastElement);
        indexMap.put(lastElement, index);
        list.remove(list.size() -1);
        indexMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

//Time Complexity is insert O(1), delete O(1) and get is O(1)
//Read NOTES before!!!
