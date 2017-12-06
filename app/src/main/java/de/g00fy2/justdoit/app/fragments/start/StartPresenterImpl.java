package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.app.activities.NavigationDrawer;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetSummonerByNameInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetVersionsInteractor;
import de.g00fy2.justdoit.app.navigation.Navigator;
import de.g00fy2.model.models.Summoner;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class StartPresenterImpl extends BasePresenterImpl implements StartContract.StartPresenter {

  private List<Summoner> favouriteSummoners = new ArrayList<>();

  @Inject StartContract.StartView view;

  @Inject GetVersionsInteractor getVersionsInteractor;
  @Inject GetSummonerByNameInteractor getSummonerByNameInteractor;
  @Inject ErrorController errorController;
  @Inject SnackbarController snackbarController;
  @Inject Navigator navigator;
  @Inject ImageLoaderController imageLoaderController;
  @Inject NavigationDrawer navigationDrawer;

  @Inject public StartPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();

    bind(getVersionsInteractor.execute().subscribe(versionList -> {
      if (versionList.size() > 0) {
        view.showCurrentVersion(versionList.get(0));
        imageLoaderController.setLatestVersion(versionList.get(0));
      }
    }, errorController::onError));
  }

  @Override public void searchSummoner(String summonerName) {
    bind(getSummonerByNameInteractor.execute(summonerName).subscribe(summoner -> {
      favouriteSummoners.add(summoner);
      view.setDefaultSummoner(summoner);
      view.notifyDataChanged();
      snackbarController.showSuccess(summoner.name + " was found!");
    }, throwable -> errorController.onError(throwable)));
  }

  @Override public void selectFavouriteSummoner(int position) {
    navigationDrawer.setNavigationDrawerHeaderData(favouriteSummoners.get(position));
  }

  @Override public Summoner getSummonerInPosition(int positon) {
    return favouriteSummoners.get(positon);
  }

  @Override public int getDataSize() {
    return favouriteSummoners.size();
  }
}
