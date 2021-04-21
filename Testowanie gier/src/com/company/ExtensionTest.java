package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionTest {

    @Test
    @ExtendWith(FileExtension.class)
    void test(@FileExtension.File(path = "D:\\University-v4\\Testowanie gier\\src\\com\\company\\data.txt") String content) {
        assertEquals(content, "testing testing extension");
    }
}