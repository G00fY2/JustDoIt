package de.g00fy2.model.datasources.db;

import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;

/**
 * Created by Thomas Wirth on 12.12.2017.
 */

public interface StaticDataDbSource {

  Single<Map<Integer, Champion>> getChampions();

  Single<Map<Integer, Champion>> saveChampions(Map<Integer, Champion> championMap);

  Completable deleteChampions();

  Single<Map<Integer, SummonerSpell>> getSummonerSpells();

  Single<Map<Integer, SummonerSpell>> saveSummonerSpells(
      Map<Integer, SummonerSpell> summonerSpellMap);

  Completable deleteSummonerSpells();
}
