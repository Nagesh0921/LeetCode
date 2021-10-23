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
    //One basic idea is reverse the linkedlist, add + 1 in current node value, think about carry
    //if carry > 9, then carry 1 else 0
    //return reverse of linkedlist
    //instead of this basically we will keep a look at digit '9' as only when we need to modify the linkedlist
    //else we will just update the value of the last node.
    public ListNode plusOne(ListNode head) {
        ListNode sentinial = new ListNode(0);
        sentinial.next = head;
        ListNode notNine = sentinial;
        
        while(head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }
        
        notNine.val++;
        System.out.println(notNine.val);
        //This is needed in case of 109
        notNine = notNine.next;
        
        while(notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        
        //What if in case of 999
        return (sentinial.val != 0) ? sentinial : sentinial.next;
    }
}
