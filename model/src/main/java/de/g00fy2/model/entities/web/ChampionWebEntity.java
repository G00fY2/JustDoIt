package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class ChampionWebEntity {

  public String name;
  public String title;
  public String key;
  public Integer id;

  @Override public String toString() {
    return "ChampionWebEntity{"
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
