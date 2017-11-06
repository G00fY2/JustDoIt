package de.g00fy2.model.datasources.web;

import de.g00fy2.model.api.RiotApi;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public class StaticDataWebDataSourceImpl implements StaticDataWebDataSource {

  @Inject RiotApi riotApi;

  @Inject public StaticDataWebDataSourceImpl() {

  }

  @Override public Single<List<String>> getVersions() {
    return riotApi.getVersions();
  }
}
