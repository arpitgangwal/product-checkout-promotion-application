package com.assignment.promotion.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DTest {

    @Test
    void getInstance() {
        assertNotNull(D.getInstance());
    }

    @Test
    void getPrice() {
        assertNotNull(D.getInstance().getPrice());
        assertEquals(15,D.getInstance().getPrice());
    }

    @Test
    void getName() {
        assertEquals("D",D.getInstance().getName());
    }
}