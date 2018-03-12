package io.apexcreations.asm.example.test;

public class Testing {
/*
  public static void main(String[] args) {
    Test test = new Test("TESTING");
    Class<?> clazz = test.getClass();

    Config configAnnotation = clazz.getAnnotation(Config.class);
    System.out.println(configAnnotation.path());
    System.out.println(configAnnotation.fileType());

    for (Method method: clazz.getMethods()) {
      ConfigValue configValue = method.getAnnotation(ConfigValue.class);
      if (configValue != null) {
        String value = null;
        try {
          value = String.valueOf(method.invoke(test));
          generateFile(configAnnotation.path(), configAnnotation.fileType());
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
        System.out.println("value: " + value + "; T: " + configValue.path());
      }
    }
  }

  private static void generateFile(String path, FileType fileType) {
    File file = new File(path + (fileType == FileType.YAML ? ".yml" : ".json"));

    if (!file.exists()) {
      FileOutputStream fileOutputStream = null;
      try {
        file.getParentFile().mkdirs();
        System.out.println("Generated: " + file.createNewFile());
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (fileOutputStream != null) {
          try {
            fileOutputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    } else {
      System.out.println(file.getAbsolutePath());
    }
  }*/
}