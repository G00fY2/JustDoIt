package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.StaticDataDataStore;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class GetVersionInteractorImpl extends BaseInteractor implements GetVersionInteractor {

  @Inject StaticDataDataStore staticDataDataStore;

  @Inject public GetVersionInteractorImpl() {
  }

  @Override public Single<String> execute() {
    return staticDataDataStore.getLatestDataVersionFromWeb().compose(single());
  }
}
