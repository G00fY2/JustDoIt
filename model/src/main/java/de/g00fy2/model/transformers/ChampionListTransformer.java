package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.db.ChampionDbEntity;
import de.g00fy2.model.entities.web.ChampionListWebEntity;
import de.g00fy2.model.models.Champion;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface ChampionListTransformer {

  Map<Integer, Champion> toModel(ChampionListWebEntity championListWebEntity);

  Map<Integer, Champion> toModel(List<ChampionDbEntity> championDbEntities);
}
