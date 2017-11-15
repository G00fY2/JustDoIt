package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.MatchlistWebEntity;
import de.g00fy2.model.models.Matchlist;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface MatchlistTransformer {

  Matchlist toModel(MatchlistWebEntity matchlistWebEntity);
}
