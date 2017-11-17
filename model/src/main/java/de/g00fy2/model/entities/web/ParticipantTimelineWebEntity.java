package de.g00fy2.model.entities.web;

import java.util.Map;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class ParticipantTimelineWebEntity {

  public String lane;
  public Integer participantId;
  public Map<String, Double> csDiffPerMinDeltas;
  public Map<String, Double> goldPerMinDeltas;
  public Map<String, Double> xpDiffPerMinDeltas;
  public Map<String, Double> creepsPerMinDeltas;
  public Map<String, Double> xpPerMinDeltas;
  public String role;
  public Map<String, Double> damageTakenDiffPerMinDeltas;
  public Map<String, Double> damageTakenPerMinDeltas;

  @Override public String toString() {
    return "ParticipantTimelineWebEntity{"
        + "lane='"
        + lane
        + '\''
        + ", participantId="
        + participantId
        + ", csDiffPerMinDeltas="
        + csDiffPerMinDeltas
        + ", goldPerMinDeltas="
        + goldPerMinDeltas
        + ", xpDiffPerMinDeltas="
        + xpDiffPerMinDeltas
        + ", creepsPerMinDeltas="
        + creepsPerMinDeltas
        + ", xpPerMinDeltas="
        + xpPerMinDeltas
        + ", role='"
        + role
        + '\''
        + ", damageTakenDiffPerMinDeltas="
        + damageTakenDiffPerMinDeltas
        + ", damageTakenPerMinDeltas="
        + damageTakenPerMinDeltas
        + '}';
  }
}
