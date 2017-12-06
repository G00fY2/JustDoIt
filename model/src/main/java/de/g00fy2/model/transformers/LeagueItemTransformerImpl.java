package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeagueItemWebEntity;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.MiniSeries;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueItemTransformerImpl implements LeagueItemTransformer {

  @Inject public LeagueItemTransformerImpl() {

  }

  @Override public LeagueItem toModel(LeagueItemWebEntity leagueItemWebEntity) {
    if (leagueItemWebEntity != null) {
      LeagueItem leagueItem = new LeagueItem();
      leagueItem.rank = leagueItemWebEntity.rank;
      leagueItem.hotStreak = leagueItemWebEntity.hotStreak;
      leagueItem.wins = leagueItemWebEntity.wins;
      leagueItem.veteran = leagueItemWebEntity.veteran;
      leagueItem.losses = leagueItemWebEntity.losses;
      leagueItem.freshBlood = leagueItemWebEntity.freshBlood;
      leagueItem.playerOrTeamName = leagueItemWebEntity.playerOrTeamName;
      leagueItem.inactive = leagueItemWebEntity.inactive;
      leagueItem.playerOrTeamId = leagueItemWebEntity.playerOrTeamId;
      leagueItem.leaguePoints = leagueItemWebEntity.leaguePoints;
      if (leagueItemWebEntity.miniSeries != null) {
        leagueItem.miniSeries = new MiniSeries();
        leagueItem.miniSeries.wins = leagueItemWebEntity.miniSeries.wins;
        leagueItem.miniSeries.losses = leagueItemWebEntity.miniSeries.losses;
        leagueItem.miniSeries.target = leagueItemWebEntity.miniSeries.target;
        leagueItem.miniSeries.progress = leagueItemWebEntity.miniSeries.progress;
      }

      return leagueItem;
    }

    return null;
  }
}
