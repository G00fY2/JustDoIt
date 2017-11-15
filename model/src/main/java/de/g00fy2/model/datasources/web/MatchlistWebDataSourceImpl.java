package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.models.Matchlist;
import de.g00fy2.model.transformers.MatchlistTransformer;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchlistWebDataSourceImpl implements MatchlistWebDataSource {

  @Inject RiotApi riotApi;
  @Inject MatchlistTransformer matchlistTransformer;

  @Inject MatchlistWebDataSourceImpl() {

  }

  @Override public Single<Matchlist> getMatchlistByAccountId(String accountId) {
    return riotApi.getMatchlistByAccountId(accountId).map(matchlistTransformer::toModel);
  }
}
