import JavaExamples.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test // tests must start with @Test
    public void checkHasHello() {
        // assertTrue checks a condition is true, optional message
        assertTrue("Must contain \"Hello\"", HelloWorld.getHelloWorld().contains("Hello"));
    }

    @Test
    public void checkHasWorld() {
        assertTrue("Must contain \"world\"", HelloWorld.getHelloWorld().contains("world"));
    }

    @Test
    public void checkHasSpace() {
        assertTrue("Must contain a space", HelloWorld.getHelloWorld().contains(" "));
    }

    @Test
    public void checkHasExclamation() {
        assertTrue("Must contain a '!'", HelloWorld.getHelloWorld().contains("!"));
    }

    @Test
    public void checkExactMatch() {
        // assertEquals compares and checks for equality
        assertEquals("Must exactly match \"Hello world!\"","Hello world!", HelloWorld.getHelloWorld());
    }

    @Test
    public void runAllTests() {
        // a single Test can contain multiple checks, and can call other Tests
        checkHasHello();
        checkHasWorld();
        checkHasSpace();
        checkHasExclamation();
        checkExactMatch();
    }
}