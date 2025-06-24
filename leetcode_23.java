// 23. Merge k Sorted Lists

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

// optimal using recursion to both break the array in half and merging the lists
// tc - O(NlogK)
// sc - O(logK) - recursion stack

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode solve(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode left = solve(lists, start, mid);
            ListNode right = solve(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        }
        return null;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return solve(lists, 0, lists.length - 1);
    }
}
