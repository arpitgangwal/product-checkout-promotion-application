package com.assignment.promotion.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ATest {

    @Test
    void getInstance() {
        assertNotNull(A.getInstance());
    }

    @Test
    void getPrice() {
        assertNotNull(A.getInstance().getPrice());
        assertEquals(50,A.getInstance().getPrice());
    }

    @Test
    void getName() {
        assertEquals("A",A.getInstance().getName());
    }
}