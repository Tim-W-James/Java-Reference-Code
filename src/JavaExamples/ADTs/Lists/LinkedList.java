package JavaExamples.ADTs.Lists;

public class LinkedList<T> implements List<T> {
    LL first, last;
    int elements;

    class LL {
        T value;
        LL next;

        public LL(T value, LL next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next == null)
                return value.toString();
            else
                return value + " " + next;
        }
    }


    @Override
    public void add(T value) {
        if (first == null)  // adding to an empty LinkedList
            first = last = new LL(value, null);
        else {
            last.next = new LL(value, null);
            last = last.next;
        }
        elements++;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            first = first.next;
            if (first == null) last = null; // we just removed the only node, so fix last
        } else {
            LL prior = getLL(first, index -1 );
            prior.next = prior.next.next;
            if (prior.next == null)
                last = prior;
        }
        elements--;
    }

    @Override
    public int size() {
        return elements;
    }

    private LL getLL(LL start, int index) {
        if (index == 0)
            return start;
        else
            return getLL(start.next, index -1);
    }

    @Override
    public T get(int index) {

        return getLL(first, index).value;
    }

    private LL recursiveReversal(LL oldFirst) {
        if (oldFirst.next == null)
            return oldFirst;
        else {
            LL newPrior = oldFirst.next;
            LL first = recursiveReversal(newPrior);
            newPrior.next = oldFirst;
            return first;
        }
    }


    @Override
    public void reverse() {
        if (first == null)
            return; // nothing to do
        else {
            last = first;
            first = recursiveReversal(first);
            last.next = null;
        }

    }

    @Override
    public String toString() {
        if (first == null)
            return "";
        else
            return first.toString();
    }
}
