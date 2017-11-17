package de.g00fy2.model.entities.web;

import java.util.List;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class MatchWebEntity {

  public Integer seasonId;
  public Integer queueId;
  public Long gameId;
  public List<ParticipantIdentityWebEntitiy> participantIdentities;
  public String gameVersion;
  public String platformId;
  public String gameMode;
  public Integer mapId;
  public String gameType;
  public List<TeamStatsWebEnitity> teams;
  public List<ParticipantWebEntity> participants;
  public Long gameDuration;
  public Long gameCreation;

  @Override public String toString() {
    return "MatchWebEntity{"
        + "seasonId="
        + seasonId
        + ", queueId="
        + queueId
        + ", gameId="
        + gameId
        + ", participantIdentities="
        + participantIdentities
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
        + ", teams="
        + teams
        + ", participants="
        + participants
        + ", gameDuration="
        + gameDuration
        + ", gameCreation="
        + gameCreation
        + '}';
  }
}
