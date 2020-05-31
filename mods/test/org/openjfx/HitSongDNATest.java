package org.openjfx;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HitSongDNATest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = { "AllTests"})
    public void testTestTesting() {
        HitSongDNA hsa = new HitSongDNA();
       boolean yo= hsa.testTesting();
       assertEquals(true,yo);
    }
}