package com.wmw.dice;

public class CommonDieTest {

  public static void main(String[] args) {
    CommonDie die = new CommonDie();
    if (!(die instanceof Die)) {
      throw new RuntimeException("Die interface is not implemented.");
    }
  }

}
