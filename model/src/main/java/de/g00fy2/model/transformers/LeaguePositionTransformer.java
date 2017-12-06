package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.models.LeaguePosition;
import java.util.Set;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public interface LeaguePositionTransformer {

  Set<LeaguePosition> toModel(Set<LeaguePositionWebEntity> leaguePositionWebEntitySet);
}
