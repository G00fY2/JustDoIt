package de.g00fy2.justdoit.app.fragments.league_position;

import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.justdoit.app.fragments.base.BaseView;
import de.g00fy2.model.models.LeagueItem;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public interface LeaguePositionContract {

  interface LeaguePositionPresenter extends BasePresenter {

    void setSummoner(Summoner summoner);

    LeagueItem getLeaguePositionInPosition(int position);

    int getDataSize();

  }

  interface LeaguePositionView extends BaseView {

    void dataChanged();

    void setSummonerData(Summoner summoner);

    void setLeagueData(LeaguePosition leagueData);
  }
}
