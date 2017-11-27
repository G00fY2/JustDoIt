package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.models.MiniSeries;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeaguePositionTransformerImpl implements LeaguePositionTransformer {

  @Inject public LeaguePositionTransformerImpl() {

  }

  @Override public LeaguePosition toModel(LeaguePositionWebEntity leaguePositionWebEntity) {
    if (leaguePositionWebEntity != null) {
      LeaguePosition leaguePosition = new LeaguePosition();
      leaguePosition.rank = leaguePositionWebEntity.rank;
      leaguePosition.hotStreak = leaguePositionWebEntity.hotStreak;
      leaguePosition.wins = leaguePositionWebEntity.wins;
      leaguePosition.veteran = leaguePositionWebEntity.veteran;
      leaguePosition.losses = leaguePositionWebEntity.losses;
      leaguePosition.freshBlood = leaguePositionWebEntity.freshBlood;
      leaguePosition.playerOrTeamName = leaguePositionWebEntity.playerOrTeamName;
      leaguePosition.inactive = leaguePositionWebEntity.inactive;
      leaguePosition.playerOrTeamId = leaguePositionWebEntity.playerOrTeamId;
      leaguePosition.leaguePoints = leaguePositionWebEntity.leaguePoints;
      if (leaguePositionWebEntity.miniSeries != null) {
        leaguePosition.miniSeries = new MiniSeries();
        leaguePosition.miniSeries.wins = leaguePositionWebEntity.miniSeries.wins;
        leaguePosition.miniSeries.losses = leaguePositionWebEntity.miniSeries.losses;
        leaguePosition.miniSeries.target = leaguePositionWebEntity.miniSeries.target;
        leaguePosition.miniSeries.progress = leaguePositionWebEntity.miniSeries.progress;
      }

      return leaguePosition;
    }

    return null;
  }
}
