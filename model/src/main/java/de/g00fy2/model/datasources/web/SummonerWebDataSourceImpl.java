package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.models.Summoner;
import de.g00fy2.model.transformers.SummonerTransformer;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class SummonerWebDataSourceImpl implements SummonerWebDataSource {

  @Inject RiotApi riotApi;
  @Inject SummonerTransformer summonerTransformer;

  @Inject public SummonerWebDataSourceImpl() {

  }

  @Override public Single<Summoner> getSummonerByName(String summonerName) {
    return riotApi.getSummonerByName(summonerName).map(summonerTransformer::toModel);
  }
}
