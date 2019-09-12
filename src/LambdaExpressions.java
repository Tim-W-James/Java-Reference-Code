import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

// functional interface
// must have only a single abstract method, to be defined by a lambda expression
interface StringFunction {
    String apply(String a, String b);
}

public class LambdaExpressions {
    // simple methods which apply functional interfaces
    private static boolean applyIntPredicate (int value, IntPredicate predicate) {
        return predicate.test(value);
    }
    private static int applyIntFunction (int value, IntFunction function) {
        return (int) function.apply(value);
    }
    private static String applyStringFunction (String a, String b, StringFunction function) {
        return function.apply(a, b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // handles inputs
        System.out.println("Enter a number:");
        int a = in.nextInt();

        // 'x -> x == 5' is the lambda statement, which returns a boolean
        System.out.println(a+" == 5 is "+applyIntPredicate(a, (int x) -> x == 5));

        // 'x -> x + 1' is the lambda statement, which returns an int (note that x is inferred to be an int)
        System.out.println(a+" + 1 is "+applyIntFunction(a, x -> x + 1));


        System.out.println("\nEnter a String:");
        String b = in.next();
        System.out.println("Enter another String:");
        String c = in.next();

        // '(String x, String y) -> x.charAt(0) +""+ y.charAt(0)' is the lambda statement, which returns a String
        System.out.println("The first characters of "+b+" and "+c+" combined is "+applyStringFunction(b, c, (String x, String y) -> x.charAt(0) +""+ y.charAt(0)));
    }
}
