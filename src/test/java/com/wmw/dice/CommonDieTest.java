package com.wmw.dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CommonDieTest {

  CommonDie die;

  @Before
  public void setUp() {
    die = new CommonDie();
  }

  @Test
  public void dieInterfaceMustBeImplemented() {
    assertTrue(die instanceof Die);
  }

  @Test
  public void everyNewDieGetsDifferentInitialValue() {
    Set<Integer> values = new HashSet<Integer>();
    for (int i = 0; i < 1000; i++) {
      die = new CommonDie();
      values.add(die.getValue());
    }
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)), values);
  }

}
