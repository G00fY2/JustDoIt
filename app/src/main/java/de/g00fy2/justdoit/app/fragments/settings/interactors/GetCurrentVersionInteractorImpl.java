package de.g00fy2.justdoit.app.fragments.settings.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.StaticDataDataStore;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class GetCurrentVersionInteractorImpl extends BaseInteractor
    implements GetCurrentVersionInteractor {

  @Inject public StaticDataDataStore staticDataDataStore;

  @Inject GetCurrentVersionInteractorImpl() {

  }

  @Override public Single<String> execute() {
    return staticDataDataStore.getVersions()
        .flatMapObservable(Observable::fromIterable)
        .firstOrError()
        .compose(single());
  }
}
