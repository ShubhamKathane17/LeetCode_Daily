// 143. Reorder List

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


// brute force - reversing the other half of the list and then performing the given operation
// tc - O(n)
// asc - O(1) 
// sc - O(n) - system stack in the recursion

class Solution {
     public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverseList(slow);
        ListNode curr = head;

        while(rev.next != null){
            ListNode tempCurr = curr.next;
            curr.next = rev;
            ListNode tempRev = rev.next;
            rev.next = tempCurr;
            curr = tempCurr;
            rev = tempRev;
        }
    }
}


// better - using stack to store the elements in the reverse order and we use the half elements to perform the given operation
// tc - O(n)
// sc - O(n)

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        int k = stack.size() / 2;

        ListNode curr = head;

        while (k > 0) {
            ListNode topNode = stack.pop();
            ListNode tempCurr = curr.next;
            curr.next = topNode;
            topNode.next = tempCurr;
            curr = tempCurr;
            k--;
        }
        curr.next = null;
    }
}

// optimal using recursion to perform the given operation
// tc - O(n)
// asc - O(1)
// sc - O(n) - system stack is used
class Solution {
    ListNode curr;

    public void solve(ListNode head) {
        if (head == null) {
            return;
        }
        solve(head.next);

        ListNode temp = curr.next;
        if (curr.next == null) {
            return;
        }
        else if (curr == head) {
            curr.next = null;
            return;
        }

        curr.next = head;
        head.next = (temp == head) ? null : temp;
        curr = temp;
    }

    public void reorderList(ListNode head) {
        curr = head;
        solve(head);
    }
}
