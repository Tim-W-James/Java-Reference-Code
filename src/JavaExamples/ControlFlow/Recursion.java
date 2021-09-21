package JavaExamples.ControlFlow;

public class Recursion {
    private static void recursiveMethodA (int acc) {
        if (acc == 0) { // base case
            System.out.println(acc);
        }
        else { // step case
            System.out.println(acc);
            recursiveMethodA(acc - 1); // recursive call
        }
    }

    public static void main(String[] args) {
        recursiveMethodA(5);
    }
}
