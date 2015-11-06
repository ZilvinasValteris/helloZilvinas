package com.noths.hellozilvinas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zilvinas on 20/10/15.
 */
public class MainTest {

    @Test
    public void testAGreetingIsReturned(){
        CallMe callMe = new CallMe();
        assertEquals("Hello Zilvinas!", callMe.callMeMaybe());
    }
}
