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
  public void nullInitialValueIsNotAcceptable1() {
    try {
      new CommonDie(null);
      fail();
    } catch (NullPointerException e) {}
  }

  @Test(expected = NullPointerException.class)
  public void nullInitialValueIsNotAcceptable2() {
    new CommonDie(null);
  }

  @Test
  public void nullInitialValueIsNotAcceptable3() {
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("Initial value can't be null.");
    new CommonDie(null);
  }

}
