package com.customview;

import android.test.InstrumentationTestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestAndroidClass extends InstrumentationTestCase  {

    public void testAddition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}