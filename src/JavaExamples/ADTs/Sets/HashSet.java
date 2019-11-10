package JavaExamples.ADTs.Sets;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    final static int DEFAULT_BKTS = 2; // start small while testing, then make bigger

    LinkedList<T>[] table;
    int elements;

    public HashSet() {
        table = new LinkedList[DEFAULT_BKTS];
    }

    private int hash(T element) {
        return Math.abs(element.hashCode()) % DEFAULT_BKTS;
    }

    @Override
    public void add(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll == null) // check whether there's a linked list here
            ll = table[bkt] = new LinkedList<T>();
        if (!ll.contains(element)) { // check whether the element is already in the set
            ll.add(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll != null) {
            if(ll.remove(element))
                elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll == null)
            return false;
        else
            return ll.contains(element);
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String rtn = "";
        for (int bkt = 0; bkt < table.length; bkt++) {
            LinkedList<T> ll = table[bkt];
            if (ll != null) {
                for (T e : ll) {
                    if (!rtn.equals(""))
                        rtn += ", ";
                    rtn += e;
                }
            }
        }

        return rtn;
    }
}
