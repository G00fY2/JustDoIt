package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.local.SharedPreferencesDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataDataStoreImpl implements StaticDataDataStore {

  private Map<Integer, Champion> cachedChampionList;
  private Map<Integer, SummonerSpell> cachedSummonerSpellList;

  @Inject StaticDataWebDataSource staticDataWebDataSource;
  @Inject SharedPreferencesDataSource sharedPreferencesDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Single<Map<Integer, Champion>> getChampions() {
    // TODO proper database caching
    if (cachedChampionList == null || cachedChampionList.size() == 0) {
      return staticDataWebDataSource.getChampions().flatMap(champions -> {
        cachedChampionList = champions;
        return Single.just(champions);
      });
    }
    return Single.just(cachedChampionList);
  }

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells() {
    // TODO proper database caching
    if (cachedSummonerSpellList == null || cachedSummonerSpellList.size() == 0) {
      return staticDataWebDataSource.getSummonerSpells()
          .onErrorReturnItem(new HashMap<>())
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
