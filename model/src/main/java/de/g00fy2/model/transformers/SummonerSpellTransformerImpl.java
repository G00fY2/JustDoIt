package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.SummonerSpellListWebEntity;
import de.g00fy2.model.entities.web.SummonerSpellWebEntity;
import de.g00fy2.model.models.SummonerSpell;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class SummonerSpellTransformerImpl implements SummonerSpellTransformer {

  @Inject SummonerSpellTransformerImpl() {

  }

  @Override
  public Map<Integer, SummonerSpell> toModel(SummonerSpellListWebEntity summonerSpellWebEntity) {
    if (summonerSpellWebEntity != null && summonerSpellWebEntity.data != null) {
      Map<Integer, SummonerSpell> summonerSpellMap = new HashMap<>();
      for (SummonerSpellWebEntity summonerSpellWebEntity1 : summonerSpellWebEntity.data.values()) {
        SummonerSpell summonerSpell = new SummonerSpell();
        summonerSpell.id = summonerSpellWebEntity1.id;
        summonerSpell.summonerLevel = summonerSpellWebEntity1.summonerLevel;
        summonerSpell.name = summonerSpellWebEntity1.name;
        summonerSpell.key = summonerSpellWebEntity1.key;
        summonerSpell.description = summonerSpellWebEntity1.description;

        summonerSpellMap.put(summonerSpellWebEntity1.id, summonerSpell);
      }

      return summonerSpellMap;
    }

    return null;
  }
}
