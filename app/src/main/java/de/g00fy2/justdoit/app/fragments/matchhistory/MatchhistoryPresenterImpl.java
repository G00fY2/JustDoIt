package de.g00fy2.justdoit.app.fragments.matchhistory;

import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.matchhistory.interactors.GetAccountMatchlistInteractor;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Summoner;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public class MatchhistoryPresenterImpl extends BasePresenterImpl
    implements MatchhistoryContract.MatchhistoryPresenter {

  private Summoner summoner;
  private List<Match> matches = new ArrayList<>();

  @Inject MatchhistoryContract.MatchhistoryView view;

  @Inject GetAccountMatchlistInteractor getAccountMatchlistInteractor;
  @Inject ErrorController errorController;

  @Override public void bind(Disposable subscription) {

  }

  @Override public void onCreate() {

  }

  @Override public void onResume() {
    super.onResume();
    getLatestMatches();
  }

  @Override public void onPause() {

  }

  @Override public void setSummoner(Summoner summoner) {
    this.summoner = summoner;
  }

  private void getLatestMatches() {
    matches.clear();
    String accountId = Long.toString(summoner.accountId);
    bind(getAccountMatchlistInteractor.execute(accountId).subscribe(match -> {
      matches.add(match);
      view.dataChanged();
    }, errorController::onError, () -> Timber.d("onCompleted")));
  }

  @Override public Match getMatchInPosition(int position) {
    return matches.get(position);
  }

  @Override public int getDataSize() {
    return matches.size();
  }
}

