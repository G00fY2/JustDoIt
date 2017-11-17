package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class TeamBansWebEntity {

  public Integer pickTurn;
  public Integer championId;

  @Override public String toString() {
    return "TeamBansWebEntity{" + "pickTurn=" + pickTurn + ", championId=" + championId + '}';
  }
}
