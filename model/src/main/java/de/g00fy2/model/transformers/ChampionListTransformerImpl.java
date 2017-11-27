package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.ChampionListWebEntity;
import de.g00fy2.model.entities.web.ChampionWebEntity;
import de.g00fy2.model.models.Champion;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public class ChampionListTransformerImpl implements ChampionListTransformer {

  @Inject ChampionListTransformerImpl() {

  }

  @Override public List<Champion> toModel(ChampionListWebEntity championListWebEntity) {
    if (championListWebEntity != null && championListWebEntity.data != null) {
      List<Champion> championList = new ArrayList<>();
      for (ChampionWebEntity championWebEntity : championListWebEntity.data.values()) {
        Champion champion = new Champion();
        champion.name = championWebEntity.name;
        champion.title = championWebEntity.title;
        champion.key = championWebEntity.key;
        champion.id = championWebEntity.id;
        championList.add(champion);
      }

      return championList;
    }

    return null;
  }
}
