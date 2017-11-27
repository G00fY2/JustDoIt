package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.SummonerSpellListWebEntity;
import de.g00fy2.model.models.SummonerSpell;
import java.util.List;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface SummonerSpellTransformer {

  List<SummonerSpell> toModel(SummonerSpellListWebEntity summonerSpellListWebEntity);
}
