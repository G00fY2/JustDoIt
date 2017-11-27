package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.ChampionListWebEntity;
import de.g00fy2.model.models.Champion;
import java.util.List;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface ChampionListTransformer {

  List<Champion> toModel(ChampionListWebEntity championListWebEntity);
}