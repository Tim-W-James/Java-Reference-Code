package JavaExamples.ADTs.Lists;

public interface List<T> {
    public void add(T value);
    public void remove(int index);
    public int size();
    public T get(int index);
    public void reverse();
    public String toString();
}
