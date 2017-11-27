package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.LeagueWebDataSource;
import de.g00fy2.model.models.LeagueList;
import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Single;
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

  @Override public Single<LeagueList> getLeagueLists(String leagueId) {
    return leagueWebDataSource.getLeagueLists(leagueId);
  }
}
