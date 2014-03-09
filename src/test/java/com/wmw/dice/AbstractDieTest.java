package com.wmw.dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AbstractDieTest {

  Die<Integer> die;
  List<Integer> range = Arrays.asList(1, 2, 3, 4, 5, 6);

  @Before
  public void setUp() {
    die = newAbstractDie();
  }

  private Die<Integer> newAbstractDie() {
    return new AbstractDie<Integer>() {

      @Override
      protected List<Integer> getDialect() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
      }

    };
  }

  @Test
  public void dieInterfaceMustBeImplemented() {
    assertTrue(die instanceof Die);
  }

  @Test
  public void everyNewDieGetsDifferentInitialValue() {
    Set<Integer> values = new HashSet<Integer>();
    for (int i = 0; i < 1000; i++) {
      die = newAbstractDie();
      values.add(die.getValue());
    }
    assertEquals(new HashSet<Integer>(range), values);
  }

  @Test
  public void rollToChangeTheValue() {
    Set<Integer> values = new HashSet<Integer>();
    for (int i = 0; i < 1000; i++) {
      die.roll();
      values.add(die.getValue());
    }
    assertEquals(new HashSet<Integer>(range), values);
  }

  @Test
  public void getValueOnlyReturnsValidValues() {
    for (int i = 0; i < 1000; i++) {
      assertTrue(range.contains(die.getValue()));
    }
  }

  @Test
  public void getAllValuesReturnsAllPossibleValues() {
    assertEquals(range, die.getAllValues());
  }

  @Test
  public void ensureTheReflexivityOfEquals() {
    assertTrue(die.equals(die));
  }

  @Test
  public void ensureTheSymmetryOfEquals() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (!otherDie.getValue().equals(die.getValue()));
    assertTrue(die.equals(otherDie));
    assertTrue(otherDie.equals(die));
  }

  @Test
  public void ensureTheTransitivityOfEquals() {
    Die<Integer> die1;
    do {
      die1 = newAbstractDie();
    } while (!die1.getValue().equals(die.getValue()));
    Die<Integer> die2;
    do {
      die2 = newAbstractDie();
    } while (!die2.getValue().equals(die.getValue()));
    assertTrue(die.equals(die1));
    assertTrue(die1.equals(die2));
    assertTrue(die2.equals(die));
  }

  @Test
  public void diceWithDifferentValuesAreNotEqual() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (otherDie.getValue().equals(die.getValue()));
    assertFalse(die.equals(otherDie));
  }

  @Test
  public void dieAndOtherObjectAreNotEqual() {
    assertFalse(die.equals(1));
  }

  @Test
  public void dieAndNullObjectAreNotEqual() {
    assertFalse(die.equals(null));
  }

  @Test
  public void diceWithTheSameValueHaveTheSameHashCode() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (!otherDie.getValue().equals(die.getValue()));
    assertEquals(die.hashCode(), otherDie.hashCode());
  }

  @Test
  public void diceWithDifferentValuesHaveDifferentHashCodes() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (otherDie.getValue().equals(die.getValue()));
    assertNotEquals(die.hashCode(), otherDie.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(die.getClass().getSimpleName() + die.getAllValues() + ": "
        + die.getValue(), die.toString());
  }

}
