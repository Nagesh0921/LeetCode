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
        ListNode l1 = lists[0];
        for(int i=1; i<lists.length; i++){
            l1 = mergeTwoLinkedList(l1, lists[i]);
        }
        return l1;
    }
    
    public ListNode mergeTwoLinkedList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return (l1 != null) ? l1 : l2;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLinkedList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLinkedList(l1, l2.next);
            return l2;
        }
    }
}

//Time Complexity is O(kN) and Space is same due to recuersive Stack!!! can be done iteratively to manage it in O(1)
