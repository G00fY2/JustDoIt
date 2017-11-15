package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.MatchlistDataStore;
import de.g00fy2.model.models.Matchlist;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class GetAccountMatchlistInteractorImpl extends BaseInteractor
    implements GetAccountMatchlistInteractor {

  @Inject MatchlistDataStore matchlistDataStore;

  @Inject public GetAccountMatchlistInteractorImpl() {

  }

  @Override public Single<Matchlist> execute(String accountId) {
    return matchlistDataStore.getMatchlistByAccountId(accountId).compose(single());
  }
}
