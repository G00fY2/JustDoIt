package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataStoreImpl implements StaticDataStore {

  @Inject StaticDataWebDataSource staticDataWebDataSource;

  @Inject public StaticDataStoreImpl() {

  }

  @Override public Single<List<String>> getVersions() {
    return staticDataWebDataSource.getVersions();
  }
}
