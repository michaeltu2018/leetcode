/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        while(j.next!=null){
            j = j.next;
            if(j.val != 9){
                i = j;
            }
        }
        i.val++;
        while(i.next!=null){
            i=i.next;
            if(i.val == 9){
                i.val = 0;
            }
        }
        if(dummy.val == 0){
            return dummy.next;
        }
        return dummy;
    }
}
