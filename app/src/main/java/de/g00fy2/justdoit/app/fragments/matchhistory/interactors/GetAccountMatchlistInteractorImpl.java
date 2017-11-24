package de.g00fy2.justdoit.app.fragments.matchhistory.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.MatchDataStore;
import de.g00fy2.model.models.Match;
import io.reactivex.Observable;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class GetAccountMatchlistInteractorImpl extends BaseInteractor
    implements GetAccountMatchlistInteractor {

  @Inject MatchDataStore matchDataStore;

  @Inject public GetAccountMatchlistInteractorImpl() {

  }

  @Override public Observable<Match> execute(String accountId) {
    // return only 10 matches to avoid rate limit atm
    return matchDataStore.getMatchesByAccountId(accountId, 10).compose(observable());
  }
}
