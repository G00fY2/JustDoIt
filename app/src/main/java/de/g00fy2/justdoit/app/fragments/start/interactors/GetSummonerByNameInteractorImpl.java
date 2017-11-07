package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.SummonerDataStore;
import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class GetSummonerByNameInteractorImpl extends BaseInteractor
    implements GetSummonerByNameInteractor {

  @Inject SummonerDataStore summonerDataStore;

  @Inject GetSummonerByNameInteractorImpl() {

  }

  @Override public Single<Summoner> execute(String summonerName) {
    return summonerDataStore.getSummonerByName(summonerName).compose(single());
  }
}
