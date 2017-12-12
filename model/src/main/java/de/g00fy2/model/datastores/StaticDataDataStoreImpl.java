package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.db.StaticDataDbSource;
import de.g00fy2.model.datasources.local.SharedPreferencesDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataDataStoreImpl implements StaticDataDataStore {

  private Map<Integer, Champion> cachedChampionList;
  private Map<Integer, SummonerSpell> cachedSummonerSpellList;

  @Inject StaticDataWebDataSource staticDataWebDataSource;
  @Inject StaticDataDbSource staticDataDbSource;
  @Inject SharedPreferencesDataSource sharedPreferencesDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Single<Map<Integer, Champion>> getChampions() {
    if (cachedChampionList == null || cachedChampionList.size() == 0) {
      return Single.concat(staticDataDbSource.getChampions(),
          staticDataWebDataSource.getChampions())
          .filter(championMap -> championMap.size() > 0)
          .firstOrError()
          .flatMap(championMap -> {
            cachedChampionList = championMap;
            return Single.just(championMap);
          });
    }
    return Single.just(cachedChampionList);
  }

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells() {
    if (cachedSummonerSpellList == null || cachedSummonerSpellList.size() == 0) {
      return Single.concat(staticDataDbSource.getSummonerSpells(),
          staticDataWebDataSource.getSummonerSpells())
          .filter(summonerSpells -> summonerSpells.size() > 0)
          .firstOrError()
          .flatMap(summonerSpells -> {
            cachedSummonerSpellList = summonerSpells;
            return Single.just(summonerSpells);
          });
    }
    return Single.just(cachedSummonerSpellList);
  }

  @Override public Single<String> getLatestDataVersionFromWeb() {
    return staticDataWebDataSource.getVersions()
        .flatMapObservable(Observable::fromIterable)
        .firstOrError()
        .flatMap(this::setLatestVersion);
  }

  @Override public Single<String> setLatestVersion(String version) {
    return sharedPreferencesDataSource.setLatestPatchVersion(version);
  }

  @Override public Single<String> getDataVersion() {
    return sharedPreferencesDataSource.getLatestPatchVersion();
  }
}
