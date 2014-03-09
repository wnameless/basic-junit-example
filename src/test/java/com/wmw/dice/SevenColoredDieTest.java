package com.wmw.dice;

import static java.awt.Color.BLUE;
import static java.awt.Color.CYAN;
import static java.awt.Color.GREEN;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SevenColoredDieTest {

  SevenColoredDie die;

  @Before
  public void setUp() {
    die = new SevenColoredDie();
  }

  @Test
  public void testGetDialect() {
    assertEquals(
        new ArrayList<Color>(Arrays.asList(RED, ORANGE, YELLOW, GREEN, BLUE,
            CYAN, MAGENTA)), die.getDialect());
  }

}
