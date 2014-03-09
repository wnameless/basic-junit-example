package com.wmw.dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommonDieTest {

  CommonDie die;

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Before
  public void setUp() {
    die = new CommonDie();
  }

  @Test
  public void testGetDialect() {
    assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)),
        die.getDialect());
  }

  @Test
  public void initialValueCanBeSetByGivenInteger() {
    assertEquals(Integer.valueOf(1), new CommonDie(1).getValue());
  }

  @Test
  public void invalidInitialValueIsNotAcceptable1() {
    try {
      new CommonDie(0);
      fail();
    } catch (IllegalArgumentException e) {}
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidInitialValueIsNotAcceptable2() {
    new CommonDie(7);
  }

  @Test
  public void invalidInitialValueIsNotAcceptable3() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx
        .expectMessage("Invalid initial value(-1). Initial value must be within [1, 2, 3, 4, 5, 6].");
    new CommonDie(-1);
  }

}
