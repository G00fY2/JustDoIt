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

  private Map<Integer, Champion> cachedChampionMap;
  private Map<Integer, SummonerSpell> cachedSummonerSpellMap;

  @Inject StaticDataWebDataSource staticDataWebDataSource;
  @Inject StaticDataDbSource staticDataDbSource;
  @Inject SharedPreferencesDataSource sharedPreferencesDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Single<Map<Integer, Champion>> getChampions() {
    return getChampions(false);
  }

  @Override public Single<Map<Integer, Champion>> getChampions(boolean forceWebUpdate) {
    if (forceWebUpdate) {
      return staticDataWebDataSource.getChampions()
          .flatMap(staticDataDbSource::saveChampions)
          .flatMap(championMap -> {
            cachedChampionMap = championMap;
            return Single.just(championMap);
          });
    }

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

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells() {
    return getSummonerSpells(false);
  }

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells(boolean forceWebUpdate) {
    if (forceWebUpdate) {
      return staticDataWebDataSource.getSummonerSpells()
          .flatMap(staticDataDbSource::saveSummonerSpells)
          .flatMap(summonerSpellMap -> {
            cachedSummonerSpellMap = summonerSpellMap;
            return Single.just(summonerSpellMap);
          });
    }

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
