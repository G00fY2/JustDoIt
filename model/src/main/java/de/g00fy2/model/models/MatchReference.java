package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchReference {

  public String lane;
  public long gameId;
  public int champion;
  public String platformId;
  public int season;
  public int queue;
  public String role;
  public long timestamp;

  @Override public String toString() {
    return "MatchReference{"
        + "lane='"
        + lane
        + '\''
        + ", gameId="
        + gameId
        + ", champion="
        + champion
        + ", platformId='"
        + platformId
        + '\''
        + ", season="
        + season
        + ", queue="
        + queue
        + ", role='"
        + role
        + '\''
        + ", timestamp="
        + timestamp
        + '}';
  }
}
