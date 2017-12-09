package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Summoner;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public interface SummonerDataStore {

  Single<Summoner> getSummonerByName(String summonerName);

  Single<List<Summoner>> getStoredSummoners();

  Completable deleteStoredSummoner(long id);
}
