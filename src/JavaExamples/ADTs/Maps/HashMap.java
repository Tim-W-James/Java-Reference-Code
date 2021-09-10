package JavaExamples.ADTs.Maps;

import java.util.LinkedList;

public class HashMap<K,V> implements Map<K,V> {
    final static int DEFAULT_BKTS = 2; // start small while testing, then make bigger

    LinkedList<KVPair>[] table;
    int pairs;

    public HashMap() {
        table = new LinkedList[DEFAULT_BKTS];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    class KVPair {
        K key;
        V value;
        KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "("+key+", "+value+")";
        }
    }


    KVPair find(LinkedList<KVPair> ll, K key) {
        for (KVPair kv : ll) {
            if (kv.key.equals(key))
                return kv;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll == null) // check whether there's a linked list here
            ll = table[bkt] = new LinkedList<>();

        KVPair kv = find(ll, key);

        if (kv == null) { // check whether the element is already in the set
            kv = new KVPair(key, value);
            ll.add(kv);
            pairs++;
        } else {
            kv.value = value;
        }
    }

    @Override
    public void remove(K key) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll != null) {
            KVPair kv = find(ll, key);
            if(kv != null) {
                ll.remove(kv);
                pairs--;
            }
        }

    }

    @Override
    public V get(K key) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll == null)
            return null;
        else {
            KVPair kv = find(ll, key);
            if (kv != null)
                return kv.value;
            else
                return null;
        }
    }

    @Override
    public int size() {
        return pairs;
    }

    @Override
    public String toString() {
        String rtn = "";
        for (int bkt = 0; bkt < table.length; bkt++) {
            LinkedList<KVPair> ll = table[bkt];
            if (ll != null) {
                for (KVPair kv : ll) {
                    if (!rtn.equals(""))
                        rtn += ", ";
                    rtn += kv;
                }
            }
        }

        return rtn;
    }
}
