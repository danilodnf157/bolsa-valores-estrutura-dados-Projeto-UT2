package estruturas;

import bovespa.Registro;

public class MaxHeap {
    private Registro[] heap;
    private int size = 0;

    public MaxHeap(int capacity) {
        heap = new Registro[capacity];
    }

    public void insert(Registro r) {
        heap[size] = r;
        int i = size++;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap[p].getVolume() >= heap[i].getVolume()) break;
            Registro tmp = heap[p];
            heap[p] = heap[i];
            heap[i] = tmp;
            i = p;
        }
    }

    public Registro removeMax() {
        if (size == 0) return null;
        Registro max = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return max;
    }

    private void maxHeapify(int i) {
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        if (l < size && heap[l].getVolume() > heap[largest].getVolume()) largest = l;
        if (r < size && heap[r].getVolume() > heap[largest].getVolume()) largest = r;
        if (largest != i) {
            Registro tmp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = tmp;
            maxHeapify(largest);
        }
    }
}
