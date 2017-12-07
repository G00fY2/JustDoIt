package de.g00fy2.justdoit.app.fragments.matchhistory;

import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.justdoit.app.fragments.base.BaseView;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public interface MatchhistoryContract {

  interface MatchhistoryPresenter extends BasePresenter {

    void setSummoner(Summoner summoner);

    Match getMatchInPosition(int positon);

    int getDataSize();

    void onRefresh();
  }

  interface MatchhistoryView extends BaseView {

    void dataChanged();

    void showLoading(boolean show);
  }
}
