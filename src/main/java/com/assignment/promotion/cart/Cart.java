package com.assignment.promotion.cart;

import com.assignment.promotion.product.Product;
import com.assignment.promotion.promotion.Promotion;

import java.util.List;

public interface Cart {
    List<Product> getProducts();
    List<Promotion> getPromotion();
    double getCheckoutPrice();
}
