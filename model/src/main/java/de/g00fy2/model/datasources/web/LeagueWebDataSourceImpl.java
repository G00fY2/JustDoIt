package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.transformers.LeagueItemTransformer;
import de.g00fy2.model.transformers.LeagueListTransformer;
import de.g00fy2.model.transformers.LeaguePositionTransformer;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueWebDataSourceImpl implements LeagueWebDataSource {

  @Inject RiotApi riotApi;
  @Inject LeagueItemTransformer leagueItemTransformer;
  @Inject LeagueListTransformer leagueListTransformer;
  @Inject LeaguePositionTransformer leaguePositionTransformer;

  @Inject public LeagueWebDataSourceImpl() {

  }

  @Override public Single<Set<LeaguePosition>> getLeaguePositions(String summonerId) {
    return riotApi.getLeaguePositions(summonerId).map(leaguePositionTransformer::toModel);
  }

  @Override public Single<List<LeagueItem>> getLeague(String leagueId) {
    return riotApi.getLeague(leagueId)
        .map(leagueListTransformer::toModel)
        .map(leagueList -> leagueList.entries);
  }
}
