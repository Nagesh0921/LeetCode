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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        int size = list.size();
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        for(int i=0; i<size; i++){
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return newHead.next;
    }
}

//Time Complexity O(N+NLogN) => O(NlogN) Space Complexity O(N)


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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(mid);
        return merge(left_side, right_side);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode sentinial = new ListNode();
        ListNode prev = sentinial;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }
        prev.next = (l1 != null) ? l1 : l2;
        return sentinial.next;
    }
    
    public ListNode getMid(ListNode head){
        ListNode left = null;
        while(head != null && head.next != null){
            left = (left == null) ? head : left.next;
            head = head.next.next;
        }
        ListNode mid = left.next;
        left.next = null;
        return mid;
    }
}

