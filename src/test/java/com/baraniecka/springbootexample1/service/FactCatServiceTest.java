package com.baraniecka.springbootexample1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;

@SpringBootTest
public class FactCatServiceTest {

    FactCatService factCatService;

    @Test
    void FactCatApiHasBodyAssertThatTrue() {
        String body = factCatService.getCatFact();


        Assertions.assertTrue(!body.isBlank());
    }
}
