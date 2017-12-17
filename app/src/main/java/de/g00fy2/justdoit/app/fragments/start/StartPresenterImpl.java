package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.start.interactors.DeleteStoredSummonerInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetStoredSummonerInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetSummonerByNameInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetVersionInteractor;
import de.g00fy2.justdoit.app.navigation.NavigationDrawer;
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

  @Inject DeleteStoredSummonerInteractor deleteStoredSummonerInteractor;
  @Inject GetStoredSummonerInteractor getStoredSummonerInteractor;
  @Inject GetVersionInteractor getVersionInteractor;
  @Inject GetSummonerByNameInteractor getSummonerByNameInteractor;
  @Inject ErrorController errorController;
  @Inject SnackbarController snackbarController;
  @Inject ImageLoaderController imageLoaderController;
  @Inject NavigationDrawer navigationDrawer;

  @Inject public StartPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();
    navigationDrawer.setCheckedItem(R.id.home);

    loadStoredSummoners();
    //getLatestDataVersion();
  }

  @Override public void searchSummoner(String summonerName) {
    bind(getSummonerByNameInteractor.execute(summonerName).subscribe(summoner -> {
      view.setDefaultSummoner(summoner);
      snackbarController.showSuccess(summoner.name + " was found!");
      loadStoredSummoners();
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

  @Override public void deleteSummoner(int position) {
    if (position < favouriteSummoners.size()) {
      bind(deleteStoredSummonerInteractor.execute(favouriteSummoners.get(position).id)
          .subscribe(() -> {
            favouriteSummoners.remove(position);
            view.notifyDataChanged();
          }, errorController::onError));
    }
  }

  private void loadStoredSummoners() {
    bind(getStoredSummonerInteractor.execute().subscribe(summoners -> {
      favouriteSummoners = summoners;
      view.notifyDataChanged();
    }, errorController::onError));
  }

  private void getLatestDataVersion() {
    bind(getVersionInteractor.execute().subscribe(latestVersion -> {
      view.showCurrentVersion(latestVersion);
      imageLoaderController.setLatestVersion(latestVersion);
    }, errorController::onError));
  }
}
