package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Matchlist;
import de.g00fy2.model.transformers.MatchTransformer;
import de.g00fy2.model.transformers.MatchlistTransformer;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchWebDataSourceImpl implements MatchWebDataSource {

  @Inject RiotApi riotApi;
  @Inject MatchlistTransformer matchlistTransformer;
  @Inject MatchTransformer matchTransformer;

  @Inject MatchWebDataSourceImpl() {

  }

  @Override public Single<Matchlist> getMatchlistByAccountId(String accountId) {
    return riotApi.getMatchlistByAccountId(accountId, null, null)
        .map(matchlistTransformer::toModel);
  }

  @Override public Single<Match> getMatchByMatchId(String accountId, String matchId) {
    return riotApi.getMatchByMatchId(matchId)
        .map(matchWebEntity -> matchTransformer.toModel(accountId, matchWebEntity));
  }
}
