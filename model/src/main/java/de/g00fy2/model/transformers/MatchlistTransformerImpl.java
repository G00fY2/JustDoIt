package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.MatchlistWebEntity;
import de.g00fy2.model.models.Matchlist;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchlistTransformerImpl implements MatchlistTransformer {

  @Inject MatchlistTransformerImpl() {

  }

  @Override public Matchlist toModel(MatchlistWebEntity matchlistWebEntity) {
    if (matchlistWebEntity != null) {
      Matchlist matchlist = new Matchlist();
      matchlist.matches = new ArrayList<>();
      matchlist.totalGames = matchlistWebEntity.totalGames;
      matchlist.startIndex = matchlistWebEntity.startIndex;
      matchlist.endIndex = matchlistWebEntity.endIndex;
      if (matchlistWebEntity.matches != null) matchlist.matches.addAll(matchlistWebEntity.matches);

      return matchlist;
    }
    return null;
  }
}
