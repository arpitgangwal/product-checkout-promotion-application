package com.assignment.promotion.promotion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromotionHybridSetTest {


    private PromotionHybridSet promotionCSet;
    @BeforeEach
    void setUp() {
        promotionCSet= new PromotionHybridSet(new Date());
    }
    @Test
    void getPromotionPrice() {
        assertEquals(5,promotionCSet.getPromotionPrice());
    }

    @Test
    void getProductsName() {
        assertEquals(2, promotionCSet.getProductsName().size());
        assertEquals("C", promotionCSet.getProductsName().get(0));
        assertEquals("D", promotionCSet.getProductsName().get(1));

    }
    @Test
    void isActive(){
        assertTrue(promotionCSet.isActive());
    }
}