package de.g00fy2.model.datastores;

import de.g00fy2.model.models.LeagueList;
import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Single;
import java.util.Set;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface LeagueDataStore {

  Single<Set<LeaguePosition>> getLeaguePositions(String summonerId);

  Single<LeagueList> getLeagueLists(String leagueId);
}