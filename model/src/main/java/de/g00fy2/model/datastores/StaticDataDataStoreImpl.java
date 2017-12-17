package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.db.StaticDataDbSource;
import de.g00fy2.model.datasources.local.SharedPreferencesDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataDataStoreImpl implements StaticDataDataStore {

  private Map<Integer, Champion> cachedChampionMap;
  private Map<Integer, SummonerSpell> cachedSummonerSpellMap;

  @Inject StaticDataWebDataSource staticDataWebDataSource;
  @Inject StaticDataDbSource staticDataDbSource;
  @Inject SharedPreferencesDataSource sharedPreferencesDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Completable updateChampionData() {
    return staticDataWebDataSource.getChampions()
        .flatMap(staticDataDbSource::saveChampions)
        .map(championMap -> cachedChampionMap = championMap)
        .toCompletable();
  }

  @Override public Single<Map<Integer, Champion>> getChampions() {
    if (cachedChampionMap == null || cachedChampionMap.size() == 0) {
      return Single.concat(staticDataDbSource.getChampions(),
          staticDataWebDataSource.getChampions().flatMap(staticDataDbSource::saveChampions))
          .filter(championMap -> championMap.size() > 0)
          .firstOrError()
          .flatMap(championMap -> {
            cachedChampionMap = championMap;
            return Single.just(championMap);
          });
    }
    return Single.just(cachedChampionMap);
  }

  @Override public Completable updateSummonerSpellData() {
    return staticDataWebDataSource.getSummonerSpells()
        .flatMap(staticDataDbSource::saveSummonerSpells)
        .map(summonerSpellMap -> cachedSummonerSpellMap = summonerSpellMap)
        .toCompletable();
  }

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells() {
    if (cachedSummonerSpellMap == null || cachedSummonerSpellMap.size() == 0) {
      return Single.concat(staticDataDbSource.getSummonerSpells(),
          staticDataWebDataSource.getSummonerSpells()
              .flatMap(staticDataDbSource::saveSummonerSpells))
          .filter(summonerSpellMap -> summonerSpellMap.size() > 0)
          .firstOrError()
          .flatMap(summonerSpellMap -> {
            cachedSummonerSpellMap = summonerSpellMap;
            return Single.just(summonerSpellMap);
          });
    }
    return Single.just(cachedSummonerSpellMap);
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
