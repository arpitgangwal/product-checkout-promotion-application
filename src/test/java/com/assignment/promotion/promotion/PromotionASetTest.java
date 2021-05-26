package com.assignment.promotion.promotion;

import com.assignment.promotion.cart.CartImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(promotionASet.isActive(),true);
    }
}