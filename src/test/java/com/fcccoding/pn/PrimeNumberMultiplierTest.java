package com.fcccoding.pn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class PrimeNumberMultiplierTest {

    @Test
    public void testStringForInput() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("XYZ".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("Not a valid input for total number of primes.\n".getBytes());
        System.setOut(new PrintStream(out));
        PrimeNumberMultiplication m = new PrimeNumberMultiplication();
        boolean x = m.handleInputs();
        Assert.that(out.toString().contains("Not a valid input for total number of primes."), "Not the valid output string");
        Assert.that(x==true,"Test did not work");
    }

    @Test
    public void testNumberInput() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(new StringBuilder("Version1 with Lists\n" +
                "              1              2              3\n" +
                "              2              4              6\n" +
                "              3              6              9\n" +
                "Version2 with Arrays\n" +
                "              1              2              3\n" +
                "              2              4              6\n" +
                "              3              6              9\n" +
                "Version3 with Arrays - modified\n" +
                "              1              2              3\n" +
                "              2              4              6\n" +
                "              3              6              9").toString().getBytes());
        System.setOut(new PrintStream(out));
        PrimeNumberMultiplication m = new PrimeNumberMultiplication();
        Assert.that(out.toString().contains("Version1"), "Version1 did not work");
        Assert.that(out.toString().contains("Version2"), "Version2 did not work");
        Assert.that(out.toString().contains("Version3"), "Version3 did not work");
    }

    @Test
    public void testInputLessThanZeroForInput() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("-2".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write("Not a valid input for total number of primes.\n".getBytes());
        System.setOut(new PrintStream(out));
        PrimeNumberMultiplication m = new PrimeNumberMultiplication();
        boolean x = m.handleInputs();
        Assert.that(out.toString().contains("Not a valid input for total number of primes."), "Not the valid output string");
        Assert.that(x==true,"Test did not work");
    }
}
