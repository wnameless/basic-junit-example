package com.wmw.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CommonDie extends AbstractDie<Integer> implements
    Die<Integer> {

  private static final List<Integer> values = new ArrayList<Integer>(
      Arrays.asList(1, 2, 3, 4, 5, 6));

  public CommonDie() {}

  public CommonDie(Integer init) {
    if (init == null)
      throw new NullPointerException("Initial value can't be null.");

    value = init;
  }

  @Override
  protected List<Integer> getDialect() {
    return values;
  }

}
