package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.local.SharedPreferencesDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataDataStoreImpl implements StaticDataDataStore {

  private List<Champion> cachedChampionList;
  private List<SummonerSpell> cachedSummonerSpellList;

  @Inject StaticDataWebDataSource staticDataWebDataSource;
  @Inject SharedPreferencesDataSource sharedPreferencesDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Single<List<Champion>> getChampions() {
    // TODO proper database caching
    if (cachedChampionList == null || cachedChampionList.size() == 0) {
      return staticDataWebDataSource.getChampions().flatMap(champions -> {
        cachedChampionList = champions;
        return Single.just(champions);
      });
    }
    return Single.just(cachedChampionList);
  }

  @Override public Single<List<SummonerSpell>> getSummonerSpells() {
    // TODO proper database caching
    if (cachedSummonerSpellList == null || cachedSummonerSpellList.size() == 0) {
      return staticDataWebDataSource.getSummonerSpells().flatMap(summonerSpells -> {
        cachedSummonerSpellList = summonerSpells;
        return Single.just(summonerSpells);
      });
    }
    return Single.just(cachedSummonerSpellList);
  }

  @Override public Single<List<String>> getVersions() {
    return staticDataWebDataSource.getVersions();
  }

  @Override public Completable setLatestVersion(String version) {
    return sharedPreferencesDataSource.setLatestPatchVersion(version);
  }

  @Override public String getLatestVersion() {
    return sharedPreferencesDataSource.getLatestPatchVersion();
  }
}
