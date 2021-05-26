package com.assignment.promotion.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTest {

    @Test
    void getInstance() {
        assertNotNull(B.getInstance());
    }

    @Test
    void getPrice() {
        assertNotNull(B.getInstance().getPrice());
        assertEquals(30,B.getInstance().getPrice());
    }

    @Test
    void getName() {
        assertEquals("B", B.getInstance().getName());

    }
}