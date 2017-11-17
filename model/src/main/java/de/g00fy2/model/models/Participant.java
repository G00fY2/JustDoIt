package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class Participant {

  public int participantId;
  public String summonerName;
  public long accountId;
  public int profileIcon;
  public int championId;
  public int teamId;
  public String win;
  public int spell1Id;
  public int spell2Id;
  public String lane;
  public int kills;
  public int deaths;
  public int assists;

  @Override public String toString() {
    return "Participant{"
        + "participantId="
        + participantId
        + ", summonerName='"
        + summonerName
        + '\''
        + ", accountId="
        + accountId
        + ", profileIcon="
        + profileIcon
        + ", championId="
        + championId
        + ", teamId="
        + teamId
        + ", win='"
        + win
        + '\''
        + ", spell1Id="
        + spell1Id
        + ", spell2Id="
        + spell2Id
        + ", lane='"
        + lane
        + '\''
        + ", kills="
        + kills
        + ", deaths="
        + deaths
        + ", assists="
        + assists
        + '}';
  }
}
