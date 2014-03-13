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
  public void testGetDelegate() {
    assertEquals(
        new ArrayList<Color>(Arrays.asList(RED, ORANGE, YELLOW, GREEN, BLUE,
            CYAN, MAGENTA)), die.getDelegate());
  }

}
