package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Single;
import java.util.Map;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface StaticDataDataStore {

  Single<Map<Integer, Champion>> getChampions();

  Single<Map<Integer, Champion>> getChampions(boolean forceWebUpdate);

  Single<Map<Integer, SummonerSpell>> getSummonerSpells();

  Single<Map<Integer, SummonerSpell>> getSummonerSpells(boolean forceWebUpdate);

  Single<String> getLatestDataVersionFromWeb();

  Single<String> setLatestVersion(String version);

  Single<String> getDataVersion();
}
