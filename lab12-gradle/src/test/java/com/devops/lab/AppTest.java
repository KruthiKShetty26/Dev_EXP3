package com.devops.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App app = new App();

    @Test
    public void testMultiply() {
        assertEquals(20, app.multiply(4,5));
    }
}