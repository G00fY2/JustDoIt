package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface StaticDataDataStore {

  Single<Map<Integer, Champion>> getChampions();

  Single<Map<Integer, SummonerSpell>> getSummonerSpells();

  Single<List<String>> getVersions();

  Completable setLatestVersion(String version);

  String getLatestVersion();
}
