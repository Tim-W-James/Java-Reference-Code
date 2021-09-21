package JavaExamples.DataStructures.Maps;

public class MyBSTMap<K, V> implements MyMap<K, V> {
    BSTree tree;
    int elements;

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


    class BSTree {
        KVPair kv;
        BSTree left, right;

        BSTree add(KVPair kv) {
            if (this.kv == null) {
                this.kv = kv;
                return this;
            } else if (this.kv.equals(kv)) // we found it, so don't add, return null
                return null;
            else if (kv.key.hashCode() > this.kv.key.hashCode()) {
                if (right == null)
                    right = new BSTree();
                return right.add(kv);
            } else {
                if (left == null)
                    left = new BSTree();
                return left.add(kv);
            }
        }

        void add(BSTree subtree) {
            if (subtree != null && subtree.kv != null) {
                add(subtree.kv);
                add(subtree.left);
                add(subtree.right);
            }
        }

        BSTree find (K key) {
            if (this.kv != null && kv != null) {
                if (this.kv.key.equals(key)) // found it!
                    return this;
                else if (key.hashCode() > this.kv.key.hashCode()) {
                    if (right != null)
                        return right.find(key);
                } else {
                    if (left != null)
                        return left.find(key);
                }
            }
            return null;  // could not find it
        }


        @Override
        public String toString() {
            if (kv == null)
                return "";
            String rtn = "";
            if (left != null && left.kv != null)
                rtn += left + ", ";

            rtn += kv;

            if (right != null && right.kv != null)
                rtn += ", " + right;
            return rtn;
        }

    }


    @Override
    public void put(K key, V value) {
        if (tree == null)
            tree = new BSTree();
        BSTree t = tree.find(key);
        if (t == null) {
            KVPair kv = new KVPair(key, value);
            tree.add(kv);
            elements++;  // successfully added (ie it was not already there)
        } else {
            t.kv.value = value;
        }
    }

    @Override
    public void remove(K key) {
        BSTree root = tree.find(key);
        if (root != null) {
            BSTree l = root.left;
            BSTree r = root.right;
            root.kv = null;
            root.left = null;
            root.right = null;
            tree.add(l);
            tree.add(r);
            elements--;
        }
    }

    @Override
    public V get(K key) {
        if (tree == null)
            return null;
        else {
            BSTree t = tree.find(key);
            if (t == null)
                return null;
            else
                return t.kv.value;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        if (tree == null)
            return "";
        else
            return tree.toString();
    }
}
