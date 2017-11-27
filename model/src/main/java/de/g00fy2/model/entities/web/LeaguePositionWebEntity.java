package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 26.11.2017.
 */

public class LeaguePositionWebEntity {

  public String rank;
  public Boolean hotStreak;
  public MiniSeriesWebEntity miniSeries;
  public Integer wins;
  public Boolean veteran;
  public Integer losses;
  public Boolean freshBlood;
  public String playerOrTeamName;
  public Boolean inactive;
  public String playerOrTeamId;
  public Integer leaguePoints;

  @Override public String toString() {
    return "LeaguePositionWebEntity{"
        + "rank='"
        + rank
        + '\''
        + ", hotStreak="
        + hotStreak
        + ", miniSeries="
        + miniSeries
        + ", wins="
        + wins
        + ", veteran="
        + veteran
        + ", losses="
        + losses
        + ", freshBlood="
        + freshBlood
        + ", playerOrTeamName='"
        + playerOrTeamName
        + '\''
        + ", inactive="
        + inactive
        + ", playerOrTeamId='"
        + playerOrTeamId
        + '\''
        + ", leaguePoints="
        + leaguePoints
        + '}';
  }
}
