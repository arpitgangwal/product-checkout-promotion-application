package com.assignment.promotion.promotion;

import com.assignment.promotion.product.A;
import com.assignment.promotion.product.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionASet extends AbstractPromotion{

    final static Product[]  PRODUCT_ARRAY = {A.getInstance(),A.getInstance(),A.getInstance()};


    public PromotionASet(Date date)  {
        super(date);
        this.date = date;
    }

    @Override
    public double getPromotionPrice() {
        return Arrays.asList(PRODUCT_ARRAY).stream().mapToDouble(Product::getPrice).sum() -130;
    }

    @Override
    public List<String> getProductsName() {
        return Arrays.asList(PRODUCT_ARRAY).stream().map(Product::getName).collect(Collectors.toList());
    }

}
