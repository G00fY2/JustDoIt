package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchReferenceWebEntity {

  public String lane;
  public Long gameId;
  public Integer champion;
  public String platformId;
  public Integer season;
  public Integer queue;
  public String role;
  public Long timestamp;

  @Override public String toString() {
    return "MatchReferenceWebEntity{"
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
