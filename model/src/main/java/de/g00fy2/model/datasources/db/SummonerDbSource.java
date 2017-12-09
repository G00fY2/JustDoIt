package de.g00fy2.model.datasources.db;

import de.g00fy2.model.models.Summoner;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public interface SummonerDbSource {

  Single<List<Summoner>> getSummoners();

  Single<Summoner> getSummonerByName(String summonerName);

  Single<Summoner> saveSummoner(Summoner summoner);

  Completable deleteSummoner(long id);
}
