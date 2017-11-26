package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 26.11.2017.
 */

public class MiniSeriesWebEntity {

  public Integer wins;
  public Integer losses;
  public Integer target;
  public String progress;

  @Override public String toString() {
    return "MiniSeriesWebEntity{"
        + "wins="
        + wins
        + ", losses="
        + losses
        + ", target="
        + target
        + ", progress='"
        + progress
        + '\''
        + '}';
  }
}
