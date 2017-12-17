package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface StaticDataDataStore {

  Completable updateChampionData();

  Single<Map<Integer, Champion>> getChampions();

  Completable updateSummonerSpellData();

  Single<Map<Integer, SummonerSpell>> getSummonerSpells();

  Single<String> getLatestDataVersionFromWeb();

  Single<String> setLatestVersion(String version);

  Single<String> getDataVersion();
}
