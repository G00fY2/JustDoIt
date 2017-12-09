package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.SummonerDataStore;
import io.reactivex.Completable;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class DeleteStoredSummonerInteractorImpl extends BaseInteractor
    implements DeleteStoredSummonerInteractor {

  @Inject SummonerDataStore summonerDataStore;

  @Inject public DeleteStoredSummonerInteractorImpl() {

  }

  @Override public Completable execute(long id) {
    return summonerDataStore.deleteStoredSummoner(id).compose(completable());
  }
}
