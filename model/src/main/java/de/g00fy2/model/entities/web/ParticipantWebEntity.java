package de.g00fy2.model.entities.web;

import java.util.List;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class ParticipantWebEntity {

  public ParticipantStatsWebEntity stats;
  public Integer participantId;
  public List<RuneWebEntity> runes;
  public ParticipantTimelineWebEntity timeline;
  public Integer teamId;
  public Integer spell2Id;
  public List<MasteryWebEntity> masteries;
  public String highestAchievedSeasonTier;
  public Integer spell1Id;
  public Integer championId;

  @Override public String toString() {
    return "ParticipantWebEntity{"
        + "stats="
        + stats
        + ", participantId="
        + participantId
        + ", runes="
        + runes
        + ", timeline="
        + timeline
        + ", teamId="
        + teamId
        + ", spell2Id="
        + spell2Id
        + ", masteries="
        + masteries
        + ", highestAchievedSeasonTier='"
        + highestAchievedSeasonTier
        + '\''
        + ", spell1Id="
        + spell1Id
        + ", championId="
        + championId
        + '}';
  }
}
