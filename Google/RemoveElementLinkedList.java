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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        while(current != null){
            if(current.val == val){
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return newHead.next;
    }
}

// Time Complexity O(n) and Space O(1)
// Runtime: 1 ms, faster than 78.37% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 39.6 MB, less than 87.65% of Java online submissions for Remove Linked List Elements.



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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
            
        }
        return head;
    }
}

