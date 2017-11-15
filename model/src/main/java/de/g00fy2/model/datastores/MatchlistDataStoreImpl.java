package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.MatchlistWebDataSource;
import de.g00fy2.model.models.Matchlist;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchlistDataStoreImpl implements MatchlistDataStore {

  @Inject MatchlistWebDataSource matchlistWebDataSource;


  @Inject public MatchlistDataStoreImpl() {

  }

  @Override public Single<Matchlist> getMatchlistByAccountId(String accountId) {
    return matchlistWebDataSource.getMatchlistByAccountId(accountId);
  }
}
