package de.g00fy2.model.models;

import de.g00fy2.model.entities.web.MatchReferenceWebEntity;
import java.util.List;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class Matchlist {

  public List<MatchReferenceWebEntity> matches;
  public int totalGames;
  public int startIndex;
  public int endIndex;

  @Override public String toString() {
    return "Matchlist{"
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
