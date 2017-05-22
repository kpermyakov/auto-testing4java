package com.acme.edu;

public class TestDemoSut {
    public double divide(double a, double b) {
        if (b == 0) throw new IllegalArgumentException();
        return a/b;
    }
}
