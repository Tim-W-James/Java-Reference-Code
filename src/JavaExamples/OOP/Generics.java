package JavaExamples.OOP;

import java.util.Arrays;


// class which is Comparable
// must implement compareTo
class MyType implements Comparable<MyType> {
    private String data;

    MyType(String s) {
        data = s;
    }

    @Override
    public int compareTo(MyType other) {
        // a myType object is greater than other if its data String is longer
        return data.length() - other.data.length();
    }

    @Override
    public String toString() {
        return data;
    }
}

// generic class
// stores a object of the type 'T'
class GenericType<T> {

    private T t;

    GenericType(T t) {
        this.t = t;
    }

    T getT() {
        return t;
    }
}


public class Generics {
    /*
     generic methods
     */

    // '<T>' indicates that the method is generic, where 'T' is an inputted type
    private static <T> T[] swap(T[] a, int i, int j) {
        // declare array of type 'T'
        T[] arr = a.clone();

        if (i < 0 || i > a.length - 1 || j < 0 || j > a.length - 1) {
            return arr;
        }

        // declare variable of type 'T'
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    // use a comma to indicate multiple different types (may also be the same type)
    private static <T, U> U returnNullOfAnything (T printMe, U pointless) {
        // VERY useless method
        U arb = null;
        System.out.println(printMe);
        return arb;
    }

    // bounded generic method
    // 'T' must be comparable
    private static <T extends Comparable<T>> T largest (T a, T b) {
        if (a.compareTo(b) > b.compareTo(a))
            return a;
        else
            return b;
    }


    public static void main(String[] args) {
        /*
         swap works for any object (though not primitives, as these are not objects)
          */

        // works for Strings
        String[] stringArr = {"10", "11", "12", "13"};
        int a = 1;
        int b = 2;
        System.out.println("Before swap: "+Arrays.toString(stringArr));
        System.out.println("After swap: "+Arrays.toString(swap(stringArr, a, b)));

        // works for Integers
        Integer[] integerArr = {10, 11, 12, 13};
        System.out.println("\nBefore swap: "+Arrays.toString(integerArr));
        System.out.println("After swap: "+Arrays.toString(swap(integerArr, a, b)));


        /*
         largest works for any object, provided it is comparable
         */

        // works for Integers
        Integer x = 100;
        Integer y = 10;
        System.out.println("\nThe larger of "+x+" and "+y+" is: "+largest(x,y));

        // works for myType
        MyType i = new MyType("hi");
        MyType j = new MyType("hello");
        System.out.println("\nThe longer of "+i+" and "+j+" is: "+largest(i,j));


        /*
         generic classes
         */

        // instantiating a generic class by declaring the type it holds
        GenericType<Character> genericObjA = new GenericType<>('A');
        System.out.println("\ngenericObjA stores: '"+genericObjA.getT()+"' declared as a '"+genericObjA.getT().getClass()+"'");

        // instantiating a generic class where the type it holds is inferred
        GenericType genericObjB = new GenericType<>("Hello");
        System.out.println("\ngenericObjB stores: '"+genericObjB.getT()+"' inferred as a '"+genericObjB.getT().getClass()+"'");

        // types can also be inferred more generally with the 'var' keyword
        // inference is as specific as possible
        var genericObjC = 12.5;
        System.out.println("\ngenericObjC inferred: '"+genericObjC+"'");
    }
}
