package de.g00fy2.justdoit.app.fragments.league_position.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.LeagueDataStore;
import de.g00fy2.model.models.LeaguePosition;
import io.reactivex.Single;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class GetLeaguePositionsDataInteractorImpl extends BaseInteractor
    implements GetLeaguePositionsDataInteractor {

  @Inject LeagueDataStore leagueDataStore;

  @Inject public GetLeaguePositionsDataInteractorImpl() {

  }

  @Override public Single<Set<LeaguePosition>> execute(String summonerId) {
    return leagueDataStore.getLeaguePositions(summonerId).compose(single());
  }
}
