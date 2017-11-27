package de.g00fy2.model.datasources.web;

import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Matchlist;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface MatchWebDataSource {

  Single<Matchlist> getMatchlistByAccountId(String accountId);

  Single<Match> getMatchByMatchId(String accountId, String matchId);
}
