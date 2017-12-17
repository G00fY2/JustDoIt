package de.g00fy2.justdoit.app.controllers;

import de.g00fy2.model.datastores.StaticDataDataStore;
import de.g00fy2.model.schedulers.CompletableScheduler;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 14.12.2017.
 */

public class StaticDataVersionControllerImpl implements StaticDataVersionController {

  @Inject StaticDataDataStore staticDataDataStore;
  @Inject ImageLoaderController imageLoaderController;

  @Inject StaticDataVersionControllerImpl() {

  }

  @Override public Completable setupStaticData() {
    return Single.zip(staticDataDataStore.getDataVersion(),
        staticDataDataStore.getLatestDataVersionFromWeb(), String::equals)
        .onErrorReturnItem(true)
        .flatMapCompletable(uptodate -> {
          staticDataDataStore.getDataVersion()
              .flatMapCompletable(imageLoaderController::setLatestVersion)
              .subscribe();
          if (uptodate) {
            return CompletableObserver::onComplete;
          } else {
            return staticDataDataStore.updateChampionData()
                .andThen(staticDataDataStore.updateSummonerSpellData());
          }
        })
        .compose(new CompletableScheduler());
  }
}
