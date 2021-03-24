/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> emp = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees){
            emp.put(e.id, e);
        }
       return getImportance(id); 
    }
    
    public int getImportance(int id){
        if(!emp.containsKey(id)){
            return 0;
        }
        Employee e = emp.get(id);
        int ans = e.importance;
        for(Integer i : e.subordinates){
            ans += getImportance(i);
        }
        return ans;
    }
}
