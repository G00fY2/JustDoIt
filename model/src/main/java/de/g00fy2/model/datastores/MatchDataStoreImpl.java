package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.MatchWebDataSource;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Matchlist;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchDataStoreImpl implements MatchDataStore {

  @Inject MatchWebDataSource matchWebDataSource;

  @Inject public MatchDataStoreImpl() {

  }

  @Override public Single<Matchlist> getMatchlistByAccountId(String accountId) {
    return matchWebDataSource.getMatchlistByAccountId(accountId);
  }

  @Override public Single<Match> getMatchByMatchId(String matchId) {
    return matchWebDataSource.getMatchByMatchId(matchId);
  }

  @Override public Observable<Match> getMatchesByAccountId(String accountId, int count) {
    return matchWebDataSource.getMatchlistByAccountId(accountId)
        .flatMapObservable(matchlist -> Observable.fromIterable(matchlist.matches))
        .flatMapSingle(matchReferenceWebEntity -> getMatchByMatchId(
            Long.toString(matchReferenceWebEntity.gameId)))
        .take(count);
  }
}
