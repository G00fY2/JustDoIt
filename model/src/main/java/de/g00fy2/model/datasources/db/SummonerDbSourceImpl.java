package de.g00fy2.model.datasources.db;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import de.g00fy2.model.entities.db.SummonerDbEntity;
import de.g00fy2.model.models.Summoner;
import de.g00fy2.model.transformers.SummonerTransformer;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class SummonerDbSourceImpl implements SummonerDbSource {

  @Inject SummonerTransformer summonerTransformer;

  @Inject public SummonerDbSourceImpl() {

  }

  @Override public Single<List<Summoner>> getSummoners() {
    return Observable.just(SQLite.select().from(SummonerDbEntity.class).queryList())
        .flatMapIterable(summonerDbEntities -> summonerDbEntities)
        .map(summonerTransformer::toModel)
        .toList();
  }

  @Override public Single<Summoner> getSummonerByName(String summonerName) {
    return null;
  }

  @Override public Single<Summoner> saveSummoner(Summoner summoner) {
    return Single.just(summoner).map(summoner1 -> {
      FlowManager.getModelAdapter(SummonerDbEntity.class)
          .save(summonerTransformer.toModel(summoner1));
      return summoner1;
    });
  }
}
