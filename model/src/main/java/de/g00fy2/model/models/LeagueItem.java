package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueItem {

  public int rank;
  public boolean hotStreak;
  public MiniSeries miniSeries;
  public int wins;
  public boolean veteran;
  public int losses;
  public boolean freshBlood;
  public String playerOrTeamName;
  public boolean inactive;
  public String playerOrTeamId;
  public int leaguePoints;

  @Override public String toString() {
    return "LeagueItem{"
        + "rank="
        + rank
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
