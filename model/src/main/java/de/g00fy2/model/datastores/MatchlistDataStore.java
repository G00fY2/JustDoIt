package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Matchlist;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface MatchlistDataStore {

  Single<Matchlist> getMatchlistByAccountId(String accountId);
}
