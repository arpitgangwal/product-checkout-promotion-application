package com.assignment.promotion.product;

public class A implements Product {
    private static A a;

    private A(){};

    public static A getInstance(){
        if (a ==null)
        a = new A();
        return a;
    }

    @Override
    public double getPrice() {
        return 50;
    }

    @Override
    public String getName() {
        return "A";
    }
}
