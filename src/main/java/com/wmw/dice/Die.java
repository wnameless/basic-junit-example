package com.wmw.dice;

import java.util.List;

public interface Die<T> {

  public void roll();

  public T getValue();

  public List<T> getAllValues();

}
