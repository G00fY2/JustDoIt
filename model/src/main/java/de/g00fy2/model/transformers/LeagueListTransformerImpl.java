package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeagueListWebEntity;
import de.g00fy2.model.entities.web.LeagueItemWebEntity;
import de.g00fy2.model.models.LeagueList;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueListTransformerImpl implements LeagueListTransformer {

  @Inject LeagueItemTransformer leagueItemTransformer;

  @Inject LeagueListTransformerImpl() {

  }

  @Override public LeagueList toModel(LeagueListWebEntity leagueListWebEntity) {
    if (leagueListWebEntity != null) {
      LeagueList leagueList = new LeagueList();
      leagueList.tier = leagueListWebEntity.tier;
      leagueList.queue = leagueListWebEntity.queue;
      leagueList.name = leagueListWebEntity.name;
      if (leagueListWebEntity.entries != null) {
        leagueList.entries = new ArrayList<>();
        for (LeagueItemWebEntity leagueItemWebEntity : leagueListWebEntity.entries) {
          leagueList.entries.add(leagueItemTransformer.toModel(leagueItemWebEntity));
        }
      }

      return leagueList;
    }

    return null;
  }
}
