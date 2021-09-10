package JavaExamples;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        /*
         array list
          */
        System.out.println("--Array List--");
        ArrayList <String> list1 = new ArrayList<>(); // initialize of type String
        list1.add("Hello"); // add elements
        list1.add("World"); // this element will be removed
        list1.add("World");
        list1.remove("World"); // remove an element
        Iterator itr1 = list1.iterator(); // iterators are the root interface of all collections
        System.out.print("List: ");
        while (itr1.hasNext()) {
            System.out.print(itr1.next()+" ");
        }
        System.out.println("\nDoes the list contain \"Hello\": "+list1.contains("Hello")); // check if a list contains an element


        /*
         linked list
          */
        System.out.println("\n--Linked List--");
        LinkedList <String> list2 = new LinkedList<>(); // initialize of type String
        list2.add("Hello"); // add elements
        list2.add("World");
        list2.add("World"); // this element will be removed
        list2.removeLast(); // remove last element, note that linked lists are faster at manipulating elements
        System.out.println("List: "+list2.get(0) +" "+ list2.get(1)); // get elements of a given index
        System.out.println("Head: "+list2.getFirst()); // get the head of the list
        list2.set(1, "Hello");
        System.out.println("After changing element: "+list2.get(0)+" "+list2.get(1)); // get an element of a given index
        System.out.println("How long is the list: "+list2.size()); // get the size of a list
        // sorting lists
        LinkedList <Integer> list3 = new LinkedList<>();
        list3.add(3);
        list3.add(1);
        list3.add(2);
        System.out.println("Unsorted list: "+list3.get(0)+" "+list3.get(1)+" "+list3.get(2));
        java.util.Collections.sort(list3);
        System.out.println("Sorted list: "+list3.get(0)+" "+list3.get(1)+" "+list3.get(2));


        /*
         stack
          */
        // last in first out
        System.out.println("\n--Stack--");
        Stack <Integer> stack = new Stack<>(); // initialize of type Integer
        stack.push(1); // add elements to the top of the stack with push
        stack.push(2);
        stack.push(3);
        System.out.print("Stack: ");
        for (int x : stack) { // can use a foreach instead of an iterator
            System.out.print(x+" ");
        }
        System.out.println("\nTop of the stack: "+stack.peek()); // get the top element with peek
        stack.pop(); // remove the top element with pop
        System.out.println("Top of the stack after pop: "+stack.peek());


        /*
         queue
         */
        // first in first out
        System.out.println("\n--Queue--");
        PriorityQueue <String> queue = new PriorityQueue<>(); // initialize of type String
        queue.add("Bob"); // add elements to the end of the queue
        queue.add("Jerry");
        queue.add("Jones");
        System.out.print("Queue: ");
        queue.forEach(t -> System.out.print(t+" ")); // alternate method of iterating across the collection
        System.out.println("\nHead: "+queue.peek()); // peek to get the head of the queue
        queue.poll(); // remove head
        System.out.print("Queue after removal: ");
        queue.forEach(t -> System.out.print(t+" "));

        /*
         hash set
         */
        // unordered, does not allow duplicates
        System.out.println("\n\n--Hash Set--");
        HashSet <Integer> set1 = new HashSet<>(); // initialize of type Integer
        set1.add(1); // add elements, unordered
        set1.add(2);
        set1.add(3);
        set1.add(3); // duplicate will not be saved
        System.out.print("Hash Set: ");
        set1.forEach(t -> System.out.print(t+" "));

        /*
         hash map
         */
        System.out.println("\n\n--Hash Map--");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bob", 21); // add elements, (Key, Value)
        map.put("Jerry", 15);
        map.put("Jones", 58);
        System.out.print("\nHash Map: ");
        Set<String> keys = map.keySet(); // get the set of keys
        for (String x : keys) {
            System.out.print(map.get(x)+" ");
        }
        System.out.println("\nBob is: "+map.get("Bob")); // get the value from a key
    }
}
