// 19. Remove Nth Node From End of List

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

// brute force - using two loops to 1. calculate the length 2. to find the nth node from the end and remove it
// tc - O(n)
// sc - O(1)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tail = head;
        int count = 1;

        while(tail != null){
            if(tail.next != null){
                tail = tail.next;
            }
            else{
                break;
            }
            count++;                
        }

        if(count == 1){
            return null;
        }

        int k = count - n + 1;
        ListNode curr = null;
        ListNode nxt = head;
        k--;

        while(k != 0 && nxt.next != null){
            curr = nxt;
            nxt = nxt.next;
            k--;
        }

        if(curr == null){
            head = nxt.next;
            nxt.next = null;
            return head;
        }

        curr.next = nxt.next;
        nxt.next  = null;

        return head;
    }
}

// optimal - slow / fast or hare / tortoise method to find the nth node from the last and remove it
// tc - O(n) - worst case
// sc - O(1)

class solution{
  public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
