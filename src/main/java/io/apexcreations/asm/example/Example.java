package io.apexcreations.asm.example;

import io.apexcreations.asm.annotations.Config;
import io.apexcreations.asm.annotations.ConfigValue;

@Config(path = "%dataFolder%/test")
public class Example {

  @ConfigValue(path = "user.name")
  private String userName;

  public Example(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
