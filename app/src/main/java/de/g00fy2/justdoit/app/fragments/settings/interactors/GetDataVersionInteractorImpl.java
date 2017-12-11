package de.g00fy2.justdoit.app.fragments.settings.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.StaticDataDataStore;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class GetDataVersionInteractorImpl extends BaseInteractor
    implements GetDataVersionInteractor {

  @Inject public StaticDataDataStore staticDataDataStore;

  @Inject GetDataVersionInteractorImpl() {

  }

  @Override public Single<String> execute() {
    return staticDataDataStore.getDataVersion().compose(single());
  }
}
