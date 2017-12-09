package de.g00fy2.justdoit.app.fragments.league_position;

import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeagueItemsDataInteractor;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeaguePositionsDataInteractor;
import de.g00fy2.justdoit.app.navigation.NavigationDrawer;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.models.Summoner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class LeaguePositionPresenterImpl extends BasePresenterImpl
    implements LeaguePositionContract.LeaguePositionPresenter {

  private List<LeagueItem> leagueItemList = new ArrayList<>();
  private String leagueId;
  private Summoner summoner;

  @Inject LeaguePositionContract.LeaguePositionView view;

  @Inject NavigationDrawer navigationDrawer;
  @Inject GetLeaguePositionsDataInteractor getLeaguePositionsDataInteractor;
  @Inject GetLeagueItemsDataInteractor getLeagueItemsDataInteractor;
  @Inject ErrorController errorController;

  @Inject public LeaguePositionPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();
    navigationDrawer.setCheckedItem(R.id.league_position);
    view.setSummonerData(summoner);
    getCurrentLeaguePosition();
  }

  @Override public void setSummoner(Summoner summoner) {
    this.summoner = summoner;
  }

  @Override public LeagueItem getLeaguePositionInPosition(int position) {
    return leagueItemList.get(position);
  }

  @Override public int getDataSize() {
    return leagueItemList.size();
  }

  @Override public void loadDivision(int division) {
    getCurrentLeagueItems(leagueId, division);
  }

  private void getCurrentLeaguePosition() {
    bind(getLeaguePositionsDataInteractor.execute(Long.toString(summoner.id))
        .subscribe(this::setLeagueData, errorController::onError));
  }

  private void getCurrentLeagueItems(String leagueId, int division) {
    leagueItemList.clear();
    bind(getLeagueItemsDataInteractor.execute(leagueId, division).subscribe(leagueItems -> {
      leagueItemList = leagueItems;
      view.dataChanged();
    }, errorController::onError));
  }

  private void setLeagueData(Set<LeaguePosition> leaguePositionSet) {
    LeaguePosition rankedPosition = null;
    LeaguePosition flexPosition = null;

    if (leaguePositionSet != null && leaguePositionSet.size() > 0) {
      for (LeaguePosition leaguePosition : leaguePositionSet) {
        if (leaguePosition.queueType.equals("RANKED_SOLO_5x5")) rankedPosition = leaguePosition;
        if (leaguePosition.queueType.equals("RANKED_FLEX_SR") && rankedPosition == null) {
          flexPosition = leaguePosition;
        }
      }
    }
    if (rankedPosition != null) {
      leagueId = rankedPosition.leagueId;
      getCurrentLeagueItems(rankedPosition.leagueId, rankedPosition.rank);
      view.setLeagueData(rankedPosition);
    } else if (flexPosition != null) {
      leagueId = flexPosition.leagueId;
      getCurrentLeagueItems(flexPosition.leagueId, flexPosition.rank);
      view.setLeagueData(flexPosition);
    }
  }
}
