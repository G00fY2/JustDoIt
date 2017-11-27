package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.models.LeaguePosition;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface LeaguePositionTransformer {

  LeaguePosition toModel(LeaguePositionWebEntity leaguePositionWebEntity);
}
