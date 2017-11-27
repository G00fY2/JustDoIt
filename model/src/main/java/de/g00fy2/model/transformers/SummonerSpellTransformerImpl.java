package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.SummonerSpellListWebEntity;
import de.g00fy2.model.entities.web.SummonerSpellWebEntity;
import de.g00fy2.model.models.SummonerSpell;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class SummonerSpellTransformerImpl implements SummonerSpellTransformer {

  @Inject SummonerSpellTransformerImpl() {

  }

  @Override public List<SummonerSpell> toModel(SummonerSpellListWebEntity summonerSpellWebEntity) {
    if (summonerSpellWebEntity != null && summonerSpellWebEntity.data != null) {
      List<SummonerSpell> summonerSpellList = new ArrayList<>();
      for (SummonerSpellWebEntity summonerSpellWebEntity1 : summonerSpellWebEntity.data.values()) {
        SummonerSpell summonerSpell = new SummonerSpell();
        summonerSpell.id = summonerSpellWebEntity1.id;
        summonerSpell.summonerLevel = summonerSpellWebEntity1.summonerLevel;
        summonerSpell.name = summonerSpellWebEntity1.name;
        summonerSpell.key = summonerSpellWebEntity1.key;
        summonerSpell.description = summonerSpellWebEntity1.description;
      }

      return summonerSpellList;
    }

    return null;
  }
}
