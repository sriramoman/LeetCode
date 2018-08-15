package Session1;

import java.util.Arrays;

class Heap {
    private int[] data;
    private int size;
    private int capacity = 10;

    Heap() {
        size = 0;
        data = new int[capacity];
    }

    void offer(int value) {
        ensureExtraCapacity();
        data[size++] = value;
        heapUp();
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }

    private void heapUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > data[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapDown() {
        int parentIndex = 0;
        boolean hasToSwap = false;
        while (hasLeftChild(parentIndex)) {
            int minIndex = getLeftChildIndex(parentIndex);
            if (hasRightChild(parentIndex) && rightChild(parentIndex) < leftChild(parentIndex))
                minIndex = getRightChildIndex(parentIndex);
            if (data[parentIndex] < data[minIndex]) {
                break;
            } else {
                swap(parentIndex, minIndex);
                parentIndex = minIndex;
            }
        }
    }

    private void swap(int index1, int index2) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    public int poll() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        int pollElement = data[0];
        data[0] = data[size--];
        heapDown();
        return pollElement;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    int peek() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        return data[0];
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int leftChild(int parentIndex) {
        return data[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return data[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return data[getParentIndex(childIndex)];
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) <= size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) <= size;
    }
}

public class HeapDriver {
    public static void main(String[] args) {
        //code
        Heap h = new Heap();
        for (int i = 0; i < 80; i++) {
            h.offer(i + 10);
        }
        System.out.println(h.peek());
    }
}
