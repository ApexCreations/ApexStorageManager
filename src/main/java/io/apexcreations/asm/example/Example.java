package io.apexcreations.asm.example;

import io.apexcreations.asm.annotations.ConfigAnnotation;
import io.apexcreations.asm.annotations.ConfigValue;
import io.apexcreations.asm.enums.FileType;

@ConfigAnnotation(path = "%dataFolder%/test", fileType = FileType.YAML)
public class Example {

  private String userName;

  public Example(String userName) {
    this.userName = userName;
  }

  @ConfigValue(path = "user.name")
  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
