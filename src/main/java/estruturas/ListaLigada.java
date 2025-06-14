package estruturas;

import java.util.Iterator;
import java.util.NoSuchElementException;
import bovespa.Registro;

public class ListaLigada implements Iterable<Registro> {
    private class Node {
        Registro data;
        Node next;
        Node(Registro d) { data = d; }
    }
    private Node head;
    private int size = 0;

    public void add(Registro r) {
        if (head == null) head = new Node(r);
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = new Node(r);
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Registro> iterator() {
        return new Iterator<Registro>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public Registro next() {
                if (current == null) throw new NoSuchElementException();
                Registro data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
