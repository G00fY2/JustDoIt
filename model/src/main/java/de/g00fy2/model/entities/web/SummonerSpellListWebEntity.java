package de.g00fy2.model.entities.web;

import java.util.Map;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class SummonerSpellListWebEntity {

  public Map<String, SummonerSpellWebEntity> data;
  public String version;
  public String type;

  @Override public String toString() {
    return "SummonerSpellListWebEntity{"
        + "data="
        + data
        + ", version='"
        + version
        + '\''
        + ", type='"
        + type
        + '\''
        + '}';
  }
}
