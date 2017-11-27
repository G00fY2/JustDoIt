package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class SummonerSpell {

  public int id;
  public int summonerLevel;
  public String name;
  public String key;
  public String description;

  @Override public String toString() {
    return "SummonerSpell{"
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
