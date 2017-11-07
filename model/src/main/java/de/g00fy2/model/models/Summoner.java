package de.g00fy2.model.models;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class Summoner {

  public int profileIconId;
  public String name;
  public long summonerLevel;
  public long revisionDate;
  public long id;
  public long accountId;

  @Override public String toString() {
    return "Summoner{"
        + "profileIconId="
        + profileIconId
        + ", name='"
        + name
        + '\''
        + ", summonerLevel="
        + summonerLevel
        + ", revisionDate="
        + revisionDate
        + ", id="
        + id
        + ", accountId="
        + accountId
        + '}';
  }
}
