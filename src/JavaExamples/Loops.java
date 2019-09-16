package JavaExamples;

public class Loops {
    public static void main(String[] args) {
        System.out.println("While: ");
        int iterations = 0;
        while (iterations < 5) { // while loops repeat until the condition is false
            System.out.println(iterations);
            iterations++;
        }

        System.out.println("\nDo While: ");
        iterations = 0;
        do { // do-while checks the condition at the end of the loop
            System.out.println(iterations);
            iterations++;
        } while (iterations < 5); // code will always run at least once

        System.out.println("\nFor: ");
        for (int x = 0; x < 5; x++) { // for loops are compact, (initialization; condition; increment statement)
            System.out.println(x);
        }

        System.out.println("\nFor-Each: ");
        int[] array = { 0, 1, 2, 3, 4 };
        for (int x : array) { // foreach loops iterate across each element in an array
            System.out.println(x);
        }

        System.out.println("\nBreak and Continue in Loops: ");
        for (int x = 0; true; x++) {
            if (x > 9) {
                System.out.println("value before break: "+x);
                break; // use break to leave the loop
            }
            if (x > 4)
                continue; // continue will skip any remaining code in the block and start the next iteration
            System.out.println(x);
        }

        System.out.println("\nNested Loops: ");
        outer: // assign a label to the loop
        for (int x = 0; x < 5; x++) {
            System.out.println("outer: "+x);
            for (int y = 0; true; y++) { // nested for loop
                if (y > 2)
                    continue outer; // apply continue to the loop labeled 'outer'
                System.out.println("inner: "+y);
            }
        }
    }
}
