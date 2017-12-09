package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.model.datastores.SummonerDataStore;
import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class GetStoredSummonerInteractorImpl implements GetStoredSummonerInteractor {

  @Inject SummonerDataStore summonerDataStore;

  @Inject public GetStoredSummonerInteractorImpl() {
  }

  @Override public Single<List<Summoner>> execute() {
    return summonerDataStore.getStoredSummoners();
  }
}
