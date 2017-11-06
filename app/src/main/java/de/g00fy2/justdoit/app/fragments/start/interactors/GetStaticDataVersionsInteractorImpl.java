package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.justdoit.app.fragments.base.BaseInteractor;
import de.g00fy2.model.datastores.StaticDataStore;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class GetStaticDataVersionsInteractorImpl extends BaseInteractor
    implements GetStaticDataVersionsInteractor {

  @Inject StaticDataStore staticDataStore;

  @Inject public GetStaticDataVersionsInteractorImpl() {
  }

  @Override public Single<List<String>> execute() {
    return staticDataStore.getVersions().compose(single());
  }
}
