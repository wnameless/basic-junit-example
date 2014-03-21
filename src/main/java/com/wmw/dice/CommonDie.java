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

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import com.google.common.collect.ImmutableList;

public final class CommonDie extends AbstractDie<Integer> {

  private static final List<Integer> values = ImmutableList
      .of(1, 2, 3, 4, 5, 6);

  public CommonDie() {}

  public CommonDie(int init) {
    checkArgument(init >= 1 && init <= 6, "Invalid initial value(" + init
        + "). Initial value must be within " + values + ".");

    value = init;
  }

  @Override
  protected List<Integer> getDelegate() {
    return values;
  }

}
