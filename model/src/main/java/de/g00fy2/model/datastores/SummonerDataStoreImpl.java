package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.SummonerWebDataSource;
import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class SummonerDataStoreImpl implements SummonerDataStore {

  @Inject SummonerWebDataSource summonerWebDataSource;

  @Inject public SummonerDataStoreImpl() {

  }

  @Override public Single<Summoner> getSummonerByName(String summonerName) {
    return summonerWebDataSource.getSummonerByName(summonerName);
  }
}