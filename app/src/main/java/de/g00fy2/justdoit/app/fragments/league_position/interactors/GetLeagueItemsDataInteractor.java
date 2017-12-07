package de.g00fy2.justdoit.app.fragments.league_position.interactors;

import de.g00fy2.model.models.LeagueItem;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public interface GetLeagueItemsDataInteractor {

  Single<List<LeagueItem>> execute(String leagueId, int division);
}
