package estruturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import bovespa.Registro;

public class HashTable {
    private class Entry {
        Date key;
        ListaLigada value;
        Entry next;
    }
    private Entry[] buckets;

    public HashTable(int capacity) {
        buckets = new Entry[capacity];
    }

    private int hash(Date d) {
        return (d.hashCode() & 0x7FFFFFFF) % buckets.length;
    }

    public void put(Date d, Registro r) {
        int idx = hash(d);
        for (Entry e = buckets[idx]; e != null; e = e.next) {
            if (e.key.equals(d)) {
                e.value.add(r);
                return;
            }
        }
        Entry novo = new Entry();
        novo.key = d;
        novo.value = new ListaLigada();
        novo.value.add(r);
        novo.next = buckets[idx];
        buckets[idx] = novo;
    }

    public ListaLigada get(Date d) {
        int idx = hash(d);
        for (Entry e = buckets[idx]; e != null; e = e.next) {
            if (e.key.equals(d)) return e.value;
        }
        return null;
    }

    public List<Date> keySet() {
        List<Date> keys = new ArrayList<>();
        for (Entry bucket : buckets) {
            for (Entry e = bucket; e != null; e = e.next) {
                keys.add(e.key);
            }
        }
        return keys;
    }
}
