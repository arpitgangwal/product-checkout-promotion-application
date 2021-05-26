package com.assignment.promotion.product;

public class D implements Product {
    private static D d;

    private D(){};

    public static D getInstance(){
        if (d ==null)
            d = new D();
        return d;
    }

    @Override
    public double getPrice() {
        return 15;
    }

    @Override
    public String getName() {
        return "D";
    }
}
