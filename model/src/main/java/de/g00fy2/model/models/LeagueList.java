package de.g00fy2.model.models;

import java.util.List;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueList {

  public String tier;
  public String queue;
  public String name;
  public List<LeaguePosition> entries;

  @Override public String toString() {
    return "LeagueList{"
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
