package com.wmw.dice;

import static java.util.Collections.unmodifiableList;

import java.util.List;

abstract public class AbstractDie<T> implements Die<T> {

  private T value;

  public AbstractDie() {
    roll();
  }

  abstract protected List<T> getDialect();

  @Override
  public void roll() {
    value = getDialect().get((int) (Math.random() * getDialect().size()));
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public List<T> getAllValues() {
    return unmodifiableList(getDialect());
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Die) {
      Die<?> die = (Die<?>) o;
      return value.equals(die.getValue())
          && getDialect().equals(die.getAllValues());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 6;
    result = result ^ 31 + getDialect().hashCode();
    result = result ^ 31 + value.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return getClass().getName() + getDialect() + ": " + value;
  }

}
