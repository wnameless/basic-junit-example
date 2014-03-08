package com.wmw.dice;

import static java.awt.Color.BLUE;
import static java.awt.Color.CYAN;
import static java.awt.Color.GREEN;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SevenColoredDie extends AbstractDie<Color> implements
    Die<Color> {

  private static final List<Color> colors = new ArrayList<Color>(Arrays.asList(
      RED, ORANGE, YELLOW, GREEN, BLUE, CYAN, MAGENTA));

  @Override
  protected List<Color> getDialect() {
    return colors;
  }

}
