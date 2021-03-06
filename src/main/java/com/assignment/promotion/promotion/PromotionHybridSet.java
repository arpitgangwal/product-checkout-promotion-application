package com.assignment.promotion.promotion;

import com.assignment.promotion.product.C;
import com.assignment.promotion.product.D;
import com.assignment.promotion.product.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionHybridSet extends AbstractPromotion{
    Product[]  PRODUCT_ARRAY = {C.getInstance(), D.getInstance()};
    public PromotionHybridSet(Date date)  {
        super(date);
        this.date = date;
    }

    @Override
    public double getPromotionPrice() {
        return Arrays.asList(PRODUCT_ARRAY).stream().mapToDouble(Product::getPrice).sum() -30;
    }

    @Override
    public List<String> getProductsName() {
        return Arrays.asList(PRODUCT_ARRAY).stream().map(Product::getName).collect(Collectors.toList());
    }

}
