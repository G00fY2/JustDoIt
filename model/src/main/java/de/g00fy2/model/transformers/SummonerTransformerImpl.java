package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.SummonerDbEntity;
import de.g00fy2.model.entities.web.SummonerWebEntity;
import de.g00fy2.model.models.Summoner;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class SummonerTransformerImpl implements SummonerTransformer {

  @Inject public SummonerTransformerImpl() {

  }

  @Override public Summoner toModel(SummonerWebEntity summonerWebEntity) {
    if (summonerWebEntity != null) {
      Summoner summoner = new Summoner();
      summoner.profileIconId = summonerWebEntity.profileIconId;
      summoner.name = summonerWebEntity.name;
      summoner.summonerLevel = summonerWebEntity.summonerLevel;
      summoner.revisionDate = summonerWebEntity.revisionDate;
      summoner.id = summonerWebEntity.id;
      summoner.accountId = summonerWebEntity.accountId;

      return summoner;
    }
    return null;
  }

  @Override public Summoner toModel(SummonerDbEntity summonerDbEntity) {
    if (summonerDbEntity != null) {
      Summoner summoner = new Summoner();
      summoner.profileIconId = summonerDbEntity.profileIconId;
      summoner.name = summonerDbEntity.name;
      summoner.summonerLevel = summonerDbEntity.summonerLevel;
      summoner.revisionDate = summonerDbEntity.revisionDate;
      summoner.id = summonerDbEntity.id;
      summoner.accountId = summonerDbEntity.accountId;

      return summoner;
    }
    return null;
  }

  @Override public SummonerDbEntity toModel(Summoner summoner) {
    if (summoner != null) {
      SummonerDbEntity summonerDbEntity = new SummonerDbEntity();
      summonerDbEntity.profileIconId = summoner.profileIconId;
      summonerDbEntity.name = summoner.name;
      summonerDbEntity.summonerLevel = summoner.summonerLevel;
      summonerDbEntity.revisionDate = summoner.revisionDate;
      summonerDbEntity.id = summoner.id;
      summonerDbEntity.accountId = summoner.accountId;

      return summonerDbEntity;
    }
    return null;
  }
}
