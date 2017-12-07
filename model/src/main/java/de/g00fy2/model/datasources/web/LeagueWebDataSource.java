package de.g00fy2.model.datasources.web;

import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface LeagueWebDataSource {

  Single<Set<LeaguePosition>> getLeaguePositions(String summonerId);

  Single<List<LeagueItem>> getLeague(String leagueId);
}
