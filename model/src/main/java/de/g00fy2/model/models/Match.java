package de.g00fy2.model.models;

import java.util.List;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class Match {

  public int seasonId;
  public int queueId;
  public long gameId;
  public String win;
  public String gameVersion;
  public String platformId;
  public String gameMode;
  public int mapId;
  public String gameType;
  public long gameDuration;
  public long gameCreation;

  public List<Participant> participants;

  @Override public String toString() {
    return "Match{"
        + "seasonId="
        + seasonId
        + ", queueId="
        + queueId
        + ", gameId="
        + gameId
        + ", gameVersion='"
        + gameVersion
        + '\''
        + ", platformId='"
        + platformId
        + '\''
        + ", gameMode='"
        + gameMode
        + '\''
        + ", mapId="
        + mapId
        + ", gameType='"
        + gameType
        + '\''
        + ", gameDuration="
        + gameDuration
        + ", gameCreation="
        + gameCreation
        + ", participants="
        + participants
        + '}';
  }
}
