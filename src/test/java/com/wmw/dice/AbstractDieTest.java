/**
 *
 * @author Wei-Ming Wu
 *
 *
 * Copyright 2014 Wei-Ming Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.wmw.dice;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.testing.EqualsTester;

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
      protected List<Integer> getDelegate() {
        return range;
      }

    };
  }

  @Test
  public void dieInterfaceMustBeImplemented() {
    assertTrue(die instanceof Die);
  }

  @Test
  public void everyNewDieGetsDifferentInitialValue() {
    Set<Integer> values = newHashSet();
    for (int i = 0; i < 1000; i++) {
      die = newAbstractDie();
      values.add(die.getValue());
    }
    assertEquals(newHashSet(range), values);
  }

  @Test
  public void rollToChangeTheValue() {
    Set<Integer> values = newHashSet();
    for (int i = 0; i < 1000; i++) {
      die.roll();
      values.add(die.getValue());
    }
    assertEquals(newHashSet(range), values);
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

  @Test(expected = UnsupportedOperationException.class)
  public void listFromGetAllValuesIsUnmodifiable() {
    die.getAllValues().add(0);
  }

  @Test
  public void testEquality() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (!otherDie.getValue().equals(die.getValue()));
    new EqualsTester().addEqualityGroup(die, otherDie).testEquals();
  }

  @Test
  public void diceWithDifferentValuesAreNotEqual() {
    Die<Integer> otherDie;
    do {
      otherDie = newAbstractDie();
    } while (otherDie.getValue().equals(die.getValue()));
    assertFalse(die.equals(otherDie));
    assertNotEquals(die.hashCode(), otherDie.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(die.getClass().getSimpleName() + "{" + die.getAllValues()
        + ", " + die.getValue() + "}", die.toString());
  }

}
