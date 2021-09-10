package JavaExamples;

import java.io.*;

public class Files {
    public static void main(String[] args) {
        // system input and output
        try {
            byte b = (byte) System.in.read(); // read an input
            System.out.write(b); // input is buffered
            System.out.flush();  // flush writes content to destination
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create and write to a file
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            // get various properties of the file
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());

            // write some text to the file
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Some text and stuff");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // read a file
        FileInputStream in = null;
        try {
            in = new FileInputStream("filename.txt"); // open file input stream
            System.out.print("\nRead: ");
            for (int i = 0; i < 19; i++) {
                byte b = 0;
                b = (byte) in.read(); // read file bit
                System.out.write(b);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close(); // close input stream
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // buffered streams
        // allows for multiple bytes to be read at once, as a pose to reading 1 byte at a time
        // stored in internal buffer, faster
        BufferedInputStream inB = null;
        try {
            inB = new BufferedInputStream(new FileInputStream("filename.txt"), 10); // open file input stream
            System.out.print("\nRead: ");
            for (int i = 0; i < 19; i++) {
                byte b = 0;
                b = (byte) inB.read(); // read file bit
                System.out.write(b);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inB.close(); // close input stream
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
