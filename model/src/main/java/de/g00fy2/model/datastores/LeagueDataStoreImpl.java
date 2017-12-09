package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.LeagueWebDataSource;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class LeagueDataStoreImpl implements LeagueDataStore {

  @Inject LeagueWebDataSource leagueWebDataSource;

  @Inject LeagueDataStoreImpl() {

  }

  @Override public Single<Set<LeaguePosition>> getLeaguePositions(String summonerId) {
    return leagueWebDataSource.getLeaguePositions(summonerId);
  }

  @Override public Single<List<LeagueItem>> getLeagueItems(String leagueId) {
    return leagueWebDataSource.getLeague(leagueId);
  }

  @Override public Single<List<LeagueItem>> getLeagueItems(String leagueId, int division) {
  return leagueWebDataSource.getLeague(leagueId)
        .flatMapObservable(Observable::fromIterable)
        .filter(leagueItem -> leagueItem.rank == division)
        .toSortedList((item, nextItem) -> {
          int result = nextItem.leaguePoints - item.leaguePoints;
          if (result != 0) {
            return result;
          } else {
            return (nextItem.wins - nextItem.losses) - (item.wins - item.losses);
          }
        });
  }
}
