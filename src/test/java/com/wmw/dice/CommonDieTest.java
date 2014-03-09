package com.wmw.dice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CommonDieTest {

  CommonDie die;

  @Before
  public void setUp() {
    die = new CommonDie();
  }

  @Test
  public void testGetDialect() {
    assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)),
        die.getDialect());
  }

}
