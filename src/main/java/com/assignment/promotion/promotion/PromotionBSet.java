package com.assignment.promotion.promotion;

import com.assignment.promotion.product.B;
import com.assignment.promotion.product.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionBSet extends AbstractPromotion{
    private static final Product[]  PRODUCT_ARRAY = {B.getInstance(),B.getInstance()};
   public PromotionBSet(Date date)  {
        super(date);
        this.date = date;
    }


    @Override
    public double getPromotionPrice() {
        return Arrays.asList(PRODUCT_ARRAY).stream().mapToDouble(Product::getPrice).sum() -45;
    }

    @Override
    public List<String> getProductsName() {
        return Arrays.asList(PRODUCT_ARRAY).stream().map(Product::getName).collect(Collectors.toList());
    }


}
