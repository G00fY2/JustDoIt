package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetStaticDataVersionsInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetSummonerByNameInteractor;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class StartPresenterImpl extends BasePresenterImpl implements StartContract.StartPresenter {

  @Inject StartContract.StartView view;

  @Inject GetStaticDataVersionsInteractor getStaticDataVersionsInteractor;
  @Inject GetSummonerByNameInteractor getSummonerByNameInteractor;
  @Inject ErrorController errorController;
  @Inject SnackbarController snackbarController;

  @Inject public StartPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();

    bind(getStaticDataVersionsInteractor.execute().subscribe(versionList -> {
      if (versionList != null && versionList.size() > 0) {
        view.showCurrentVersion(versionList.get(0));
      }
    }, errorController::onError));
  }

  @Override public void searchSummoner(String summonerName) {
    bind(getSummonerByNameInteractor.execute(summonerName).subscribe(summoner -> {
      view.setDefaultSummoner(summoner);
      snackbarController.showSuccess(summoner.name + " was found!");
    }, errorController::onError));
  }
}
