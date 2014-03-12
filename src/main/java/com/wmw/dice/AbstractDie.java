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

import static java.util.Collections.unmodifiableList;

import java.util.List;

abstract public class AbstractDie<T> implements Die<T> {

  protected T value;

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
  public final boolean equals(Object o) {
    if (o instanceof Die) {
      Die<?> die = (Die<?>) o;
      return value.equals(die.getValue())
          && getDialect().equals(die.getAllValues());
    }
    return false;
  }

  @Override
  public final int hashCode() {
    int result = 6;
    result = result ^ 31 + getDialect().hashCode();
    result = result ^ 31 + value.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + getDialect() + ": " + value;
  }

}
