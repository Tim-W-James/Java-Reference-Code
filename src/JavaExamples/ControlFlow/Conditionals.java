package JavaExamples.ControlFlow;

public class Conditionals {
    public static void main(String[] args) {
        boolean condition = true;
        // if statement
        if (condition) {
            System.out.println("Condition is true");
        }

        // if-else statement
        // note compact form for single line blocks
        if (condition)
            System.out.println("Condition is true");
        else
            System.out.println("Condition is false");

        int value = 1;
        // if-else if statement
        if (value == 0)
            System.out.println("Value is 0");
        else if (value == 1)
            System.out.println("Value is 1");
        else if (value == 2)
            System.out.println("Value is 2");

        // if-else if-else statement
        if (value == 0)
            System.out.println("Value is 0");
        else if (value == 1)
            System.out.println("Value is 1");
        else
            System.out.println("Value is something else");

        // switch-case statement
        switch (value) {
            case 0:
                System.out.println("Value is 0");
                break;
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            default: // if value does not match any case, run default
                System.out.println("Value is something else");
                break;
        }

        // conditional operator
        // result = condition ? value1 : value2;
        int x = 1;
        int y = (x == 1) ? 1 : 0;

        System.out.println(y);
    }
}
