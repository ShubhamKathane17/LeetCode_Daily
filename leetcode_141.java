// 141. Linked List Cycle

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// optimal - using hare and tortoise or fast and slow pointer approach to detect the cycle in the linked list. fast is ahead of slow everytime in a linked list without cycle & if cycle is present they will point to the same node
// tc - O(n)
// sc - O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
