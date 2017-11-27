package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.models.LeagueList;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.transformers.LeagueListTransformer;
import de.g00fy2.model.transformers.LeaguePositionTransformer;
import io.reactivex.Single;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueWebDataSourceImpl implements LeagueWebDataSource {

  @Inject RiotApi riotApi;
  @Inject LeaguePositionTransformer leaguePositionTransformer;
  @Inject LeagueListTransformer leagueListTransformer;

  @Inject public LeagueWebDataSourceImpl() {

  }

  @Override public Single<Set<LeaguePosition>> getLeaguePositions(String summonerId) {
    return riotApi.getLeaguePositions(summonerId).flatMap(leaguePositionWebEntitySet -> {
      Set<LeaguePosition> leaguePositionList = new HashSet<>();
      for (LeaguePositionWebEntity leaguePositionWebEntity : leaguePositionWebEntitySet) {
        leaguePositionList.add(leaguePositionTransformer.toModel(leaguePositionWebEntity));
      }
      return Single.just(leaguePositionList);
    });
  }

  @Override public Single<LeagueList> getLeagueLists(String leagueId) {
    return riotApi.getLeagueLists(leagueId).map(leagueListTransformer::toModel);
  }
}
