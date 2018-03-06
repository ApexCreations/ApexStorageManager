package io.apexcreations.asm.annotations;

import io.apexcreations.asm.enums.FileType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfigAnnotation {

  String path();

  FileType fileType();

}
