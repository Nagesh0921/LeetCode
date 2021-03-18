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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode prev = temp;
        
        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
            head = first.next;
        }
        return temp.next;
    }
}

//Time Complexity O(N) and Space Complexity is O(1)
