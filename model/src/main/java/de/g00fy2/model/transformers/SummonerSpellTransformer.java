package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.SummonerSpellDbEntity;
import de.g00fy2.model.entities.web.SummonerSpellListWebEntity;
import de.g00fy2.model.models.SummonerSpell;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface SummonerSpellTransformer {

  Map<Integer, SummonerSpell> toModel(SummonerSpellListWebEntity summonerSpellListWebEntity);

  Map<Integer, SummonerSpell> toModel(List<SummonerSpellDbEntity> summonerSpellDbEntities);

  List<SummonerSpellDbEntity> toModel(Map<Integer, SummonerSpell> summonerSpellMap);
}
