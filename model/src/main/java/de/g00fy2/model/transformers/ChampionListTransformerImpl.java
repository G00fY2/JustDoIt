package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.ChampionDbEntity;
import de.g00fy2.model.entities.web.ChampionListWebEntity;
import de.g00fy2.model.entities.web.ChampionWebEntity;
import de.g00fy2.model.models.Champion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class ChampionListTransformerImpl implements ChampionListTransformer {

  @Inject ChampionListTransformerImpl() {

  }

  @Override public Map<Integer, Champion> toModel(ChampionListWebEntity championListWebEntity) {
    if (championListWebEntity != null && championListWebEntity.data != null) {
      Map<Integer, Champion> championMap = new HashMap<>();
      for (ChampionWebEntity championWebEntity : championListWebEntity.data.values()) {
        Champion champion = new Champion();
        champion.name = championWebEntity.name;
        champion.title = championWebEntity.title;
        champion.key = championWebEntity.key;
        champion.id = championWebEntity.id;
        championMap.put(champion.id, champion);
      }

      return championMap;
    }

    return null;
  }

  @Override public Map<Integer, Champion> toModel(List<ChampionDbEntity> championDbEntities) {
    if (championDbEntities != null && championDbEntities.size() > 0) {
      Map<Integer, Champion> championMap = new HashMap<>();
      for (ChampionDbEntity championDbEntity : championDbEntities) {
        Champion champion = new Champion();
        champion.name = championDbEntity.name;
        champion.title = championDbEntity.title;
        champion.key = championDbEntity.key;
        champion.id = championDbEntity.id;
        championMap.put(champion.id, champion);
      }

      return championMap;
    }

    return new HashMap<>();
  }

  @Override public List<ChampionDbEntity> toModel(Map<Integer, Champion> championMap) {
    if (championMap != null && championMap.size() > 0) {
      List<ChampionDbEntity> championDbEntities = new ArrayList<>();
      for (Champion champion : championMap.values()) {
        ChampionDbEntity championDbEntity = new ChampionDbEntity();
        championDbEntity.name = champion.name;
        championDbEntity.title = champion.title;
        championDbEntity.key = champion.key;
        championDbEntity.id = champion.id;
        championDbEntities.add(championDbEntity);
      }

      return championDbEntities;
    }

    return null;
  }
}
