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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0,head);
        ListNode prev = temp;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return temp.next;
    }
}

//Time Complexity O(N) and Space Complexity O(1)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
//Memory Usage: 38.3 MB, less than 56.57% of Java online submissions for Remove Duplicates from Sorted List II.
