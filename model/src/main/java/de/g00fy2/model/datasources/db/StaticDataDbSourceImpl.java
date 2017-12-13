package de.g00fy2.model.datasources.db;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.rx2.language.RXSQLite;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import de.g00fy2.model.entities.db.ChampionDbEntity;
import de.g00fy2.model.entities.db.SummonerDbEntity;
import de.g00fy2.model.entities.db.SummonerSpellDbEntity;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.SummonerSpell;
import de.g00fy2.model.transformers.ChampionListTransformer;
import de.g00fy2.model.transformers.SummonerSpellTransformer;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 12.12.2017.
 */

public class StaticDataDbSourceImpl implements StaticDataDbSource {

  @Inject ChampionListTransformer championListTransformer;
  @Inject SummonerSpellTransformer summonerSpellTransformer;

  @Inject StaticDataDbSourceImpl() {

  }

  @Override public Single<Map<Integer, Champion>> getChampions() {
    return RXSQLite.rx(SQLite.select().from(ChampionDbEntity.class))
        .queryList()
        .map(championListTransformer::toModel);
  }

  @Override
  public Single<Map<Integer, Champion>> saveChampions(Map<Integer, Champion> championMap) {
    return Single.just(championMap)
        .map(championListTransformer::toModel)
        .map(championDbEntities -> {
          FastStoreModelTransaction.saveBuilder(FlowManager.getModelAdapter(ChampionDbEntity.class))
              .addAll(championDbEntities)
              .build();
          return championMap;
        });
  }

  @Override public Completable deleteChampions() {
    return RXSQLite.rx(SQLite.delete().from(ChampionDbEntity.class)).execute();
  }

  @Override public Single<Map<Integer, SummonerSpell>> getSummonerSpells() {
    return RXSQLite.rx(SQLite.select().from(SummonerSpellDbEntity.class))
        .queryList()
        .map(summonerSpellTransformer::toModel);
  }

  @Override public Single<Map<Integer, SummonerSpell>> saveSummonerSpells(
      Map<Integer, SummonerSpell> summonerSpellMap) {
    return Single.just(summonerSpellMap)
        .map(summonerSpellTransformer::toModel)
        .map(summonerSpellDbEntities -> {
          FastStoreModelTransaction.saveBuilder(
              FlowManager.getModelAdapter(SummonerSpellDbEntity.class))
              .addAll(summonerSpellDbEntities)
              .build();
          return summonerSpellMap;
        });
  }

  @Override public Completable deleteSummonerSpells() {
    return RXSQLite.rx(SQLite.delete().from(SummonerDbEntity.class)).execute();
  }
}
