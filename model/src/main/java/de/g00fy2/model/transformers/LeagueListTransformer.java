package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.LeagueListWebEntity;
import de.g00fy2.model.models.LeagueList;

/**
 * Created by Thomas Wirth on 27.11.2017.
 */

public interface LeagueListTransformer {

  LeagueList toModel(LeagueListWebEntity leagueListWebEntity);
}
