package de.g00fy2.justdoit.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Target(ElementType.TYPE) @Inherited @Retention(RetentionPolicy.RUNTIME) public @interface Layout {
  int value();
}
