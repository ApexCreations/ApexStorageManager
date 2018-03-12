package io.apexcreations.asm;

import java.io.FileNotFoundException;

public abstract class ApexStorage {

  public abstract void save(Object object) throws FileNotFoundException;
  public abstract void load(Object object) throws FileNotFoundException;

}
