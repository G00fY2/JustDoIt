package de.g00fy2.model.datastores;

import android.support.annotation.IntRange;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Matchlist;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface MatchDataStore {

  Single<Matchlist> getMatchlistByAccountId(String accountId);

  Single<Match> getMatchByMatchId(String matchId);

  Observable<Match> getMatchesByAccountId(String accountId, @IntRange(from = 1, to = 20) int count);
}
