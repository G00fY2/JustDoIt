package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class SummonerSpellWebEntity {

  public Integer id;
  public Integer summonerLevel;
  public String name;
  public String key;
  public String description;

  @Override public String toString() {
    return "SummonerSpellWebEntity{"
        + "id="
        + id
        + ", summonerLevel="
        + summonerLevel
        + ", name='"
        + name
        + '\''
        + ", key='"
        + key
        + '\''
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
