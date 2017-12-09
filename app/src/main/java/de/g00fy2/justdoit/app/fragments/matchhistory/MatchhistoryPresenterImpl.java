package de.g00fy2.justdoit.app.fragments.matchhistory;

import android.support.v4.widget.SwipeRefreshLayout;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.matchhistory.interactors.GetAccountMatchlistInteractor;
import de.g00fy2.justdoit.app.navigation.NavigationDrawer;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Summoner;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public class MatchhistoryPresenterImpl extends BasePresenterImpl
    implements MatchhistoryContract.MatchhistoryPresenter, SwipeRefreshLayout.OnRefreshListener {

  private Summoner summoner;
  private List<Match> matches = new ArrayList<>();

  @Inject MatchhistoryContract.MatchhistoryView view;

  @Inject NavigationDrawer navigationDrawer;
  @Inject GetAccountMatchlistInteractor getAccountMatchlistInteractor;
  @Inject ErrorController errorController;

  @Override public void onResume() {
    super.onResume();
    navigationDrawer.setCheckedItem(R.id.match_history);
    getLatestMatches();
  }

  @Override public void setSummoner(Summoner summoner) {
    this.summoner = summoner;
  }

  private void getLatestMatches() {
    matches.clear();
    String accountId = Long.toString(summoner.accountId);
    view.showLoading(true);
    bind(getAccountMatchlistInteractor.execute(accountId).subscribe(match -> {
      matches.add(match);
      view.dataChanged();
    }, errorController::onError, () -> view.showLoading(false)));
  }

  @Override public Match getMatchInPosition(int position) {
    return matches.get(position);
  }

  @Override public int getDataSize() {
    return matches.size();
  }

  @Override public void onRefresh() {
    getLatestMatches();
  }
}

