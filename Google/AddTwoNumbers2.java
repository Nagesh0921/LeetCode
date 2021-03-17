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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return (l1 == null) ? l2 : l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            cur = new ListNode(sum % 10);
            cur.next = head;
            carry = sum / 10;
            head = cur;
        }
        
        if(carry != 0){
            cur = new ListNode(carry);
            cur.next = head;
            head = cur;
        }
        
        return head;
    }
}

//Time Complexity O(n+m) Space Complexity O(n+m)
//Runtime: 3 ms, faster than 63.11% of Java online submissions for Add Two Numbers II.
//Memory Usage: 39.1 MB, less than 90.46% of Java online submissions for Add Two Numbers II.
