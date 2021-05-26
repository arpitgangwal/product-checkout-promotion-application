package com.assignment.promotion.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTest {

    @Test
    void getInstance() {
        assertNotNull(C.getInstance());
    }

    @Test
    void getPrice() {
        assertNotNull(C.getInstance().getPrice());
        assertEquals(20,C.getInstance().getPrice());
    }

    @Test
    void getName() {
        assertEquals("C",C.getInstance().getName());
    }
}