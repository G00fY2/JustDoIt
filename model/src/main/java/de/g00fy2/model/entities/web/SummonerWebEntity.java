package de.g00fy2.model.entities.web;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class SummonerWebEntity {

  public Integer profileIconId;
  public String name;
  public Long summonerLevel;
  public Long revisionDate;
  public Long id;
  public Long accountId;

  @Override public String toString() {
    return "SummonerWebEntity{"
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
