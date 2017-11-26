package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class MiniSeries {

  public int wins;
  public int losses;
  public int target;
  public String progress;

  @Override public String toString() {
    return "MiniSeries{"
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
