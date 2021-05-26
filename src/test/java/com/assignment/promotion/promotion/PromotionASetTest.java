package com.assignment.promotion.promotion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PromotionASetTest {
    PromotionASet promotionASet;
    @BeforeEach
    void setUp() {
        promotionASet= new PromotionASet(new Date());
    }
    @Test
    void getPromotionPrice() {
        assertEquals(20,promotionASet.getPromotionPrice());
    }

    @Test
    void getProductsName() {
        assertEquals(3, promotionASet.getProductsName().size());
    }

    @Test
    void isActive(){
        assertTrue(promotionASet.isActive());
    }
}