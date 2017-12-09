package de.g00fy2.model.transformers;

import de.g00fy2.model.utils.LeagueUtils;
import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.models.LeaguePosition;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public class LeaguePositionTransformerImpl implements LeaguePositionTransformer {

  @Inject public LeaguePositionTransformerImpl() {

  }

  @Override
  public Set<LeaguePosition> toModel(Set<LeaguePositionWebEntity> leaguePositionWebEntitySet) {
    if (leaguePositionWebEntitySet != null && leaguePositionWebEntitySet.size() > 0) {
      Set<LeaguePosition> leaguePositionSet = new HashSet<>();
      for (LeaguePositionWebEntity leaguePositionWebEntity : leaguePositionWebEntitySet) {
        LeaguePosition leaguePosition = new LeaguePosition();
        leaguePosition.rank = LeagueUtils.transformRankToInteger(leaguePositionWebEntity.rank);
        leaguePosition.queueType = leaguePositionWebEntity.queueType;
        leaguePosition.hotStreak = leaguePositionWebEntity.hotStreak;
        leaguePosition.leagueName = leaguePositionWebEntity.leagueName;
        leaguePosition.wins = leaguePositionWebEntity.wins;
        leaguePosition.veteran = leaguePositionWebEntity.veteran;
        leaguePosition.losses = leaguePositionWebEntity.losses;
        leaguePosition.freshBlood = leaguePositionWebEntity.freshBlood;
        leaguePosition.leagueId = leaguePositionWebEntity.leagueId;
        leaguePosition.playerOrTeamName = leaguePositionWebEntity.playerOrTeamName;
        leaguePosition.inactive = leaguePositionWebEntity.inactive;
        leaguePosition.playerOrTeamId = leaguePositionWebEntity.playerOrTeamId;
        leaguePosition.tier = leaguePositionWebEntity.tier;
        leaguePosition.leaguePoints = leaguePositionWebEntity.leaguePoints;
        leaguePositionSet.add(leaguePosition);
      }
      return leaguePositionSet;
    }

    return null;
  }
}
