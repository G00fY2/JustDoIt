package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.SummonerSpellDbEntity;
import de.g00fy2.model.entities.web.SummonerSpellListWebEntity;
import de.g00fy2.model.entities.web.SummonerSpellWebEntity;
import de.g00fy2.model.models.SummonerSpell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        summonerSpellMap.put(summonerSpell.id, summonerSpell);
      }

      return summonerSpellMap;
    }

    return new HashMap<>();
  }

  @Override
  public Map<Integer, SummonerSpell> toModel(List<SummonerSpellDbEntity> summonerSpellDbEntities) {
    if (summonerSpellDbEntities != null && summonerSpellDbEntities.size() > 0) {
      Map<Integer, SummonerSpell> summonerSpellMap = new HashMap<>();
      for (SummonerSpellDbEntity summonerDbEntities : summonerSpellDbEntities) {
        SummonerSpell summonerSpell = new SummonerSpell();
        summonerSpell.id = summonerDbEntities.id;
        summonerSpell.summonerLevel = summonerDbEntities.summonerLevel;
        summonerSpell.name = summonerDbEntities.name;
        summonerSpell.key = summonerDbEntities.key;
        summonerSpell.description = summonerDbEntities.description;

        summonerSpellMap.put(summonerSpell.id, summonerSpell);
      }

      return summonerSpellMap;
    }

    return new HashMap<>();
  }

  @Override
  public List<SummonerSpellDbEntity> toModel(Map<Integer, SummonerSpell> summonerSpellMap) {
    if (summonerSpellMap != null && summonerSpellMap.size() > 0) {
      List<SummonerSpellDbEntity> summonerSpellDbEntities = new ArrayList<>();
      for (SummonerSpell summonerSpell : summonerSpellMap.values()) {
        SummonerSpellDbEntity summonerSpellDbEntity = new SummonerSpellDbEntity();
        summonerSpellDbEntity.id = summonerSpell.id;
        summonerSpellDbEntity.summonerLevel = summonerSpell.summonerLevel;
        summonerSpellDbEntity.name = summonerSpell.name;
        summonerSpellDbEntity.key = summonerSpell.key;
        summonerSpellDbEntity.description = summonerSpell.description;

        summonerSpellDbEntities.add(summonerSpellDbEntity);
      }

      return summonerSpellDbEntities;
    }

    return null;
  }
}
