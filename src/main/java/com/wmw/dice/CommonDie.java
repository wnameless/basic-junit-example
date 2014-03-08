package com.wmw.dice;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CommonDie implements Die<Integer> {

  private static final List<Integer> values = new ArrayList<Integer>(
      Arrays.asList(1, 2, 3, 4, 5, 6));
  private Integer value;

  public CommonDie() {
    roll();
  }

  @Override
  public void roll() {
    value = values.get((int) Math.random() % values.size());
  }

  @Override
  public Integer getValue() {
    return value;
  }

  @Override
  public List<Integer> getAllValues() {
    return unmodifiableList(values);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Die) {
      Die<?> die = (Die<?>) o;
      return value.equals(die.getValue()) && values.equals(die.getAllValues());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 6;
    result = result ^ 31 + values.hashCode();
    result = result ^ 31 + value;
    return result;
  }

  @Override
  public String toString() {
    return "CommonDie" + values + ": " + value;
  }

}
