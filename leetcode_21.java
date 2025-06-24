// 21. Merge Two Sorted Lists

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

// optimal - using two pointers to track the lower element btween the two listnode heads
// tc - O(n)
// sc - O(1)

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h3 = new ListNode(-1);
        ListNode temp = h3;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next; 
            }
        }

        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }

        return h3.next;
    }
}
