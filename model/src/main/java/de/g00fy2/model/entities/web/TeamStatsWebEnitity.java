package de.g00fy2.model.entities.web;

import java.util.List;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class TeamStatsWebEnitity {

  public Boolean firstDragon;
  public Boolean firstInhibitor;
  public List<TeamBansWebEntity> bans;
  public Integer baronKills;
  public Boolean firstRiftHerald;
  public Boolean firstBaron;
  public Integer riftHeraldKills;
  public Boolean firstBlood;
  public Integer teamId;
  public Boolean firstTower;
  public Integer vilemawKills;
  public Integer inhibitorKills;
  public Integer towerKills;
  public Integer dominionVictoryScore;
  public String win;
  public Integer dragonKills;

  @Override public String toString() {
    return "TeamStatsWebEnitity{"
        + "firstDragon="
        + firstDragon
        + ", firstInhibitor="
        + firstInhibitor
        + ", bans="
        + bans
        + ", baronKills="
        + baronKills
        + ", firstRiftHerald="
        + firstRiftHerald
        + ", firstBaron="
        + firstBaron
        + ", riftHeraldKills="
        + riftHeraldKills
        + ", firstBlood="
        + firstBlood
        + ", teamId="
        + teamId
        + ", firstTower="
        + firstTower
        + ", vilemawKills="
        + vilemawKills
        + ", inhibitorKills="
        + inhibitorKills
        + ", towerKills="
        + towerKills
        + ", dominionVictoryScore="
        + dominionVictoryScore
        + ", win='"
        + win
        + '\''
        + ", dragonKills="
        + dragonKills
        + '}';
  }
}
