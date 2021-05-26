package com.assignment.promotion.cart;

import com.assignment.promotion.product.Product;
import com.assignment.promotion.promotion.Promotion;

import java.util.List;
import java.util.Set;

public interface Cart {
    List<Product> getProducts();
    Set<Promotion> getPromotion();
    double getCheckoutPrice();
}
