package de.g00fy2.model.transformers;

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
}
