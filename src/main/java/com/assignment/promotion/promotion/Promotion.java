package com.assignment.promotion.promotion;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface Promotion {
    double getPromotionPrice();
    List<String> getProductsName();
    boolean isActive();
}
