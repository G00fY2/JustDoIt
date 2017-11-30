package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.StaticDataDataStore;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class GetVersionsInteractorImpl extends BaseInteractor
    implements GetVersionsInteractor {

  @Inject StaticDataDataStore staticDataDataStore;

  @Inject public GetVersionsInteractorImpl() {
  }

  @Override public Single<List<String>> execute() {
    return staticDataDataStore.getVersions().compose(single());
  }
}
