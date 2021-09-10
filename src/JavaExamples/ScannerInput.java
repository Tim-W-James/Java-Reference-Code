package JavaExamples;

import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        // create Scanner object
        Scanner in = new Scanner(System.in);

        // get a String input
        String input = in.next();
        System.out.println("You said: "+input);

        // get a String input including spaces
        input = in.nextLine();
        System.out.println("You said: "+input);

        // get an integer
        int intInput = in.nextInt();
        System.out.println("You said: "+intInput);

        // hasNext() returns true if Scanner is taking inputs
        System.out.println(in.hasNext());
    }
}
