package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.SummonerDbEntity;
import de.g00fy2.model.entities.web.SummonerWebEntity;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public interface SummonerTransformer {

  Summoner toModel(SummonerWebEntity summonerWebEntity);

  Summoner toModel(SummonerDbEntity summonerDbEntity);

  SummonerDbEntity toModel(Summoner summoner);

}
