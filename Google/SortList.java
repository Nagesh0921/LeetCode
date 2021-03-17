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
