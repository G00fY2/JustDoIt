package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataDataStoreImpl implements StaticDataDataStore {

  @Inject StaticDataWebDataSource staticDataWebDataSource;

  @Inject public StaticDataDataStoreImpl() {

  }

  @Override public Single<List<String>> getVersions() {
    return staticDataWebDataSource.getVersions();
  }
}
