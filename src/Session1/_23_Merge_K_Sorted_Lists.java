package Session1;

import java.util.Comparator;
import java.util.PriorityQueue;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _23_Merge_K_Sorted_Lists {

    public static void main(String[] args) {
        //code
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode n : lists) {
            if (n != null)
                heap.offer(n);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode iter = dummyHead;
        while (!heap.isEmpty()) {
            ListNode k = heap.poll();
            iter.next = k;
            iter = iter.next;
            if (k.next != null)
                heap.offer(k.next);
        }
        return dummyHead.next;
    }
}
