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

import java.util.Arrays;
import java.util.List;

public final class CommonDie implements Die<Integer> {

  private static final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
  private Integer value;

  public CommonDie() {
    roll();
  }

  @Override
  public void roll() {
    value = values.get((int) (Math.random() * values.size()));
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
