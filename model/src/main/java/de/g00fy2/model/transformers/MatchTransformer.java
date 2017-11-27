package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.MatchWebEntity;
import de.g00fy2.model.models.Match;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public interface MatchTransformer {

  Match toModel(String accountId, MatchWebEntity matchWebEntity);
}
