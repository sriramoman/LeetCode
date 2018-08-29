package Session1;

import java.util.LinkedHashMap;

public class _138CopyListWithRandomPointer {
    public static RandomListNode copyRandomList(RandomListNode head) {
        LinkedHashMap<RandomListNode, RandomListNode> map = new LinkedHashMap<>();
        RandomListNode iter = head;
        while (iter != null) {
            map.put(iter, new RandomListNode(iter.label));
            iter = iter.next;
        }
        iter = head;
        while (iter != null) {
            RandomListNode node = map.get(iter);
            node.next = map.get(iter.next);
            node.random = map.get(iter.random);
            iter = iter.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        //code
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.next.random = head.next;
        head = copyRandomList(head);
        RandomListNode temp = head;
        while (temp != null) {
            System.out.print(temp.label + " ");
            temp = temp.next;
        }
        System.out.println();
        while (head != null) {
            System.out.print(head.label + " ");
            head = head.random;
            System.out.println("It is " + 3 / 2);
        }
    }

    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
