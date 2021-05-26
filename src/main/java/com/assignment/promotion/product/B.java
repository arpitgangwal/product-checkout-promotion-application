package com.assignment.promotion.product;

public class B implements Product {
    private static B b;

    private B(){};

    public static B getInstance(){
        if (b ==null)
            b = new B();
        return b;
    }

    @Override
    public double getPrice() {
        return 30;
    }

    @Override
    public String getName() {
        return "B";
    }
}
