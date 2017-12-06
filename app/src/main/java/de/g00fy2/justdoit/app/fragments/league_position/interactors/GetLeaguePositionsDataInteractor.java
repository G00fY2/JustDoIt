package de.g00fy2.justdoit.app.fragments.league_position.interactors;

import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Single;
import java.util.Set;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public interface GetLeaguePositionsDataInteractor {

  Single<Set<LeaguePosition>> execute(String summonerId);
}
