package de.g00fy2.model.entities.web;

import java.util.List;

/**
 * Created by Thomas Wirth on 26.11.2017.
 */

public class LeagueListWebEntity {

  public String tier;
  public String queue;
  public String name;
  public List<LeaguePositionWebEntity> entries;

  @Override public String toString() {
    return "LeagueListWebEntity{"
        + "tier='"
        + tier
        + '\''
        + ", queue='"
        + queue
        + '\''
        + ", name='"
        + name
        + '\''
        + ", entries="
        + entries
        + '}';
  }
}
