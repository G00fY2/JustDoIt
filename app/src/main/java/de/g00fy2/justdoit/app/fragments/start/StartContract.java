package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.justdoit.app.fragments.base.BaseView;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public interface StartContract {

  interface StartPresenter extends BasePresenter {

    void searchSummoner(String summonerName);

    void searchMatches();
  }

  interface StartView extends BaseView {

    void showCurrentVersion(String currentVersion);

    void setDefaultSummoner(Summoner summmoner);

    void activateMatchsearch(boolean activate);
  }
}
