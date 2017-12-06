package de.g00fy2.justdoit.app.fragments.league_position.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.LeagueDataStore;
import de.g00fy2.model.models.LeagueItem;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 06.12.2017.
 */

public class GetLeagueItemsDataInteractorImpl extends BaseInteractor
    implements GetLeagueItemsDataInteractor {

  @Inject LeagueDataStore leagueDataStore;

  @Inject public GetLeagueItemsDataInteractorImpl() {

  }

  @Override public Single<List<LeagueItem>> execute(String leagueId) {
    return leagueDataStore.getLeagueLists(leagueId)
        .map(leagueList -> leagueList.entries)
        .compose(single());
  }
}
