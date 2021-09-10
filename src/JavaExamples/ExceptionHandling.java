package JavaExamples;

import java.util.Scanner;

/*
 creating your own exceptions
 */
// custom exceptions are created from a class which extends Exception

// exception which will be checked at runtime
// can be checked or unchecked
class InvalidInputExceptionA extends RuntimeException {
    InvalidInputExceptionA(String message) {
        super(message);
    }
}

// exception which will be checked at compile time
// must be checked or will not compile
class InvalidInputExceptionB extends Exception {
    InvalidInputExceptionB(String message) {
        super(message);
    }
}


/*
 throwing and checking exceptions
*/

public class ExceptionHandling {
    // example of an unchecked exception within a method
    // unchecked exceptions will cause the program to terminate when thrown
    // InvalidInputExceptionA extends RuntimeException, so it will compile
    private static int charToDigitA (char input) {
        if (input >= '0' && input <= '9') {
            return (int) input-48;
        }
        else { // throw exception with custom message
            throw new InvalidInputExceptionA("not a number");
        }
    }

    // example of a checked exception within a method
    // InvalidInputExceptionB extends Exception, so it must be checked
    // will not compile if left unchecked
    // any possible exceptions must be declared after 'throws' keyword
    private static int charToDigitB (char input) throws InvalidInputExceptionB {
        if (input >= '0' && input <= '9') {
            return (int) input-48;
        }
        else { // throw exception with custom message
            throw new InvalidInputExceptionB("not a number");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // handles inputs

        // unchecked exception
        // terminates on exception thrown
        System.out.println("Enter a digit (unchecked exception):");
        char inputA = in.next().charAt(0);
        System.out.println("charToDigit returned: "+charToDigitA(inputA));

        // checked exception
        // does not terminate on exception thrown
        // any exceptions thrown within a 'try' block will immediately check if there is..
        // ... a 'catch' block for that respective exception
        System.out.println("\nEnter a digit (checked exception):");
        char inputB;
        while (true) {
            inputB = in.next().charAt(0);
            try {
                System.out.println("charToDigit returned: " + charToDigitB(inputB));
                break; //only runs if the the previous line has no exceptions
            } catch (InvalidInputExceptionB ex) {
                System.out.println("Exception: "+ex.getMessage()+". Try another input:");
            }
        }

        // checked exception
        // does not terminate on exception thrown
        // 'finally' blocks will always be executed after a 'try' or 'catch' block
        System.out.println("\nEnter a digit (checked exception, with 'finally'):");
        char inputC;
        int acc = 0;
        while (true) {
            inputC = in.next().charAt(0);
            try {
                System.out.println("charToDigit returned: " + charToDigitB(inputC));
                break; //only runs if the the previous line has no exceptions
            } catch (InvalidInputExceptionB ex) {
                System.out.println("Exception: "+ex.getMessage()+". Try another input:");
            }
            finally {
                System.out.println("Attempts made: "+acc+ "");
                acc++;
            }
        }
    }
}
