package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import de.g00fy2.model.transformers.ChampionListTransformer;
import de.g00fy2.model.transformers.SummonerSpellTransformer;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataWebDataSourceImpl implements StaticDataWebDataSource {

  @Inject RiotApi riotApi;
  @Inject ChampionListTransformer championListTransformer;
  @Inject SummonerSpellTransformer summonerSpellTransformer;

  @Inject public StaticDataWebDataSourceImpl() {

  }

  @Override public Single<List<Champion>> getChampions() {
    return riotApi.getChampionList().map(championListTransformer::toModel);
  }

  @Override public Single<List<SummonerSpell>> getSummonerSpells() {
    return riotApi.getSummonerSpellList().map(summonerSpellTransformer::toModel);
  }

  @Override public Single<List<String>> getVersions() {
    return riotApi.getVersions();
  }
}
