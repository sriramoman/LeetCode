package Session1;

public class AddTwoNumbersDriver {

    public static void main(String[] args) {
        //code
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return new ListNode(0);
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null || l2 != null) {
            int val0 = l1 == null ? 0 : l1.val;
            int val1 = l2 == null ? 0 : l2.val;
            int val = val0 + val1 + carry;
            carry = val > 9 ? 1 : 0;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry != 0)
            curr.next = new ListNode(carry);
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
