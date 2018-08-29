package Session1;

import java.util.Stack;

public class _206_Reverse_Linked_List {

    public static void main(String[] args) {
        //code
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode iter = head;
        while (iter != null) {
            stack.push(iter);
            iter = iter.next;
        }
        ListNode dummyHead = new ListNode(0);
        iter = dummyHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            iter.next = node;
            iter = iter.next;
        }
        iter.next = null;
        return dummyHead.next;
    }
}
