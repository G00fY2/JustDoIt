package de.g00fy2.model.entities.web;

import java.util.List;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchlistWebEntity {

  public List<MatchReferenceWebEntity> matches;
  public Integer totalGames;
  public Integer startIndex;
  public Integer endIndex;

  @Override public String toString() {
    return "MatchlistWebEntity{"
        + "matches="
        + matches
        + ", totalGames="
        + totalGames
        + ", startIndex="
        + startIndex
        + ", endIndex="
        + endIndex
        + '}';
  }
}
