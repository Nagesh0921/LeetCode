/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for(ListNode n : lists){
            while(n != null){
                list.add(n.val);
                n = n.next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i = 0; i<list.size(); i++){
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head.next;
    }
}

//Time Complexity O(n*m + n*logn + n) => O(nLogn) Space Complexity O(N LogN)
// This is Brute Force Approach.
//Runtime: 6 ms, faster than 35.32% of Java online submissions for Merge k Sorted Lists.
//Memory Usage: 40.2 MB, less than 92.91% of Java online submissions for Merge k Sorted Lists.

