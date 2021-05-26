package com.assignment.promotion.product;

public class C implements Product {
    private static C c;

    private C(){}

    public static C getInstance(){
        if (c ==null)
            c = new C();
        return c;
    }

    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public String getName() {
        return "C";
    }
}
