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
  public String championName;
  public String championKey;
  public int teamId;
  public String win;
  public int spell1Id;
  public String spell1Name;
  public String spell1Key;
  public int spell2Id;
  public String spell2Name;
  public String spell2Key;
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
        + ", championName='"
        + championName
        + '\''
        + ", championKey='"
        + championKey
        + '\''
        + ", teamId="
        + teamId
        + ", win='"
        + win
        + '\''
        + ", spell1Id="
        + spell1Id
        + ", spell1Name='"
        + spell1Name
        + '\''
        + ", spell1Key='"
        + spell1Key
        + '\''
        + ", spell2Id="
        + spell2Id
        + ", spell2Name='"
        + spell2Name
        + '\''
        + ", spell2Key='"
        + spell2Key
        + '\''
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
