/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> uniqueVal = new HashSet<>();
        while(head != null){
            if(uniqueVal.contains(head)){
                return true;
            } else {
                uniqueVal.add(head);
            }
            head = head.next;
        }
        return false;
    }
}

// Time Complexity O(n) and Space Complexity is O(n)


// Beats RunTime
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
// Memory Usage: 40.2 MB, less than 33.67% of Java online submissions for Linked List Cycle.
// This is called Flyod's Cycle Algorithm or Runner's Method(most commonly known)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
