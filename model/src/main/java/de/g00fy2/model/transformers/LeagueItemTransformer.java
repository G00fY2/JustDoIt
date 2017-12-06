package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeagueItemWebEntity;
import de.g00fy2.model.models.LeagueItem;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface LeagueItemTransformer {

  LeagueItem toModel(LeagueItemWebEntity leagueItemWebEntity);
}
