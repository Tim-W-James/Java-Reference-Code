package JavaExamples.Concurrency;

import java.util.concurrent.TimeUnit;

// option A: Extend the Thread class
class ThreadTypeA extends Thread {
    ThreadTypeA() { // thread constructor
        this.setName(""+this.getId());
    }

    public void run() // begins in the run method
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getName() +
                    " is running");

            for(int x = 0; x < 3; x++) {
                Thread.sleep(50); // sleep for 50 ms
                System.out.println("Thread "+this.getName()+" is on "+x);
            }

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception caught");
        }
    }
}

//option B: Extend the Runnable interface
class ThreadTypeB implements Runnable {
    public void run() // begins in the run method
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception caught");
        }
    }
}

// for demonstration of synchronized
class PrintDemo {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}

// example of a synchronized thread
class ThreadSync extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo  PD;

    ThreadSync( String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        synchronized(PD) { // synchronized block can only be run by 1 thread at a time
            PD.printCount();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

// example of a non synchronized thread
class ThreadNonSync extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo  PD;

    ThreadNonSync( String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    public void run() {
        PD.printCount();
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        ThreadTypeA t1 = new ThreadTypeA();
        t1.start(); // invoke the thread

        ThreadTypeA t2 = new ThreadTypeA();
        t2.start();

        ThreadTypeA t3 = new ThreadTypeA();
        t3.start();

        ThreadTypeA t4 = new ThreadTypeA();
        t4.setName("HighPriority"); // set a thread name
        t4.setPriority(Thread.MAX_PRIORITY); // set priority, between 0 and 10
        t4.start();

        ThreadTypeA t5 = new ThreadTypeA();
        t5.setName("LowPriority");
        t5.setPriority(Thread.MIN_PRIORITY);
        t5.start();

        System.out.println("Thread "+t4.getName()+" has not been joined");
        try {
            t4.join(); // wait until t1 finishes
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread "+t4.getName()+" has now been joined");

        ThreadTypeA t6 = new ThreadTypeA();
        t6.start();
        TimeUnit.MILLISECONDS.sleep(50); // sleep main thread
        t6.interrupt(); // interrupt stops the thread
        System.out.println("Thread "+t6.getName()+" was interrupted");
        t5.join(); // wait for lowest priority thread

        // demonstrate use of synchronized
        PrintDemo PD = new PrintDemo();
        // not synchronized
        System.out.println("\nSynced");
        ThreadSync t7 = new ThreadSync( " 1 sync: ", PD );
        ThreadSync t8 = new ThreadSync( " 2 sync: ", PD );
        t7.start();
        t8.start();

        TimeUnit.MILLISECONDS.sleep(50);

        // synchronized
        System.out.println("\nNot synced");
        ThreadNonSync t9 = new ThreadNonSync( " 1: ", PD );
        ThreadNonSync t10 = new ThreadNonSync( " 2: ", PD );
        t9.start();
        t10.start();
    }
}
