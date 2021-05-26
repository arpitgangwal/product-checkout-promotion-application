package com.assignment.promotion.cart;

import com.assignment.promotion.product.*;
import com.assignment.promotion.promotion.Promotion;
import com.assignment.promotion.promotion.PromotionASet;
import com.assignment.promotion.promotion.PromotionBSet;
import com.assignment.promotion.promotion.PromotionHybridSet;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CartImplTest {
     CartImpl cartImpl;
     List<Product> productList;
     Set<Promotion> promotionSet;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        productList= new ArrayList<>();
        promotionSet = new HashSet<>();
        System.setProperty("promotionNumber","3");

        cartImpl = new CartImpl(productList,promotionSet);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getProducts() {
        assertNotNull(cartImpl.getProducts());
    }

    @org.junit.jupiter.api.Test
    void getPromotion() {
        assertNotNull(cartImpl.getPromotion());
    }

    @org.junit.jupiter.api.Test
    void getCheckoutPrice() {
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        promotionSet.add(new PromotionASet(new Date()));
        assertEquals(cartImpl.getCheckoutPrice(), 190.0);
    }

    @org.junit.jupiter.api.Test
    void getCheckoutPriceTestPromotionB() {
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        promotionSet.add(new PromotionBSet(new Date()));
        assertEquals(cartImpl.getCheckoutPrice(), 195.0);
    }
    @org.junit.jupiter.api.Test
    void getCheckoutPriceTestPromotionHybrid() {
        productList.add(C.getInstance());
        productList.add(B.getInstance());
        productList.add(A.getInstance());
        productList.add(D.getInstance());
        productList.add(B.getInstance());
        promotionSet.add(new PromotionHybridSet(new Date()));
        assertEquals(cartImpl.getCheckoutPrice(), 140.0);
    }

    @org.junit.jupiter.api.Test
    void getCheckoutPriceTestPromotionWithMultiple() {
        System.setProperty("promotionNumber","1");

        productList.add(C.getInstance());
        productList.add(B.getInstance());
        productList.add(A.getInstance());
        productList.add(D.getInstance());
        productList.add(B.getInstance());
        promotionSet.add(new PromotionHybridSet(new Date()));
        promotionSet.add(new PromotionASet(new Date()));
        assertThrows(
                RuntimeException.class,
                () -> {  new CartImpl(productList,promotionSet); }
        );    }


    @org.junit.jupiter.api.Test
    void getCheckoutPriceTestScenario1() {
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        productList.add(C.getInstance());
        promotionSet.add(new PromotionASet(new Date()));
        promotionSet.add(new PromotionHybridSet(new Date()));
        promotionSet.add(new PromotionBSet(new Date()));
        assertEquals(cartImpl.getCheckoutPrice(), 100.0);
    }

    @org.junit.jupiter.api.Test
    void getCheckoutPriceTestScenario2() {
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(A.getInstance());
        productList.add(B.getInstance());
        productList.add(B.getInstance());
        productList.add(B.getInstance());
        productList.add(B.getInstance());
        productList.add(B.getInstance());
        productList.add(C.getInstance());
        promotionSet.add(new PromotionASet(new Date()));
        promotionSet.add(new PromotionHybridSet(new Date()));
        promotionSet.add(new PromotionBSet(new Date()));
        assertEquals(cartImpl.getCheckoutPrice(), 370.0);
    }
}