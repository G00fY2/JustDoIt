package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class Champion {

  public String name;
  public String title;
  public String key;
  public int id;

  @Override public String toString() {
    return "Champion{"
        + "name='"
        + name
        + '\''
        + ", title='"
        + title
        + '\''
        + ", key='"
        + key
        + '\''
        + ", id="
        + id
        + '}';
  }
}
