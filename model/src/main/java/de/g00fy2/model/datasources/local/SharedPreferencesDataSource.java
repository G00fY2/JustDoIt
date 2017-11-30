package de.g00fy2.model.datasources.local;

import io.reactivex.Completable;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public interface SharedPreferencesDataSource {

  Completable setLatestPatchVersion(String version);

  String getLatestPatchVersion();
}
