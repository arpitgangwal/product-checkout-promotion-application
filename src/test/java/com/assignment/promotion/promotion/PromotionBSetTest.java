package com.assignment.promotion.promotion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromotionBSetTest {

    private PromotionBSet promotionBSet;
    @BeforeEach
    void setUp() {
        promotionBSet= new PromotionBSet(new Date());
    }
    @Test
    void getPromotionPrice() {
        assertEquals(15,promotionBSet.getPromotionPrice());
    }

    @Test
    void getProductsName() {
        assertEquals(2, promotionBSet.getProductsName().size());
    }
    @Test
    void isActive(){
        assertTrue(promotionBSet.isActive());
    }
}