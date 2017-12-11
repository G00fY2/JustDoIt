package de.g00fy2.model.datasources.local;

import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public interface SharedPreferencesDataSource {

  Single<String> setLatestPatchVersion(String version);

  Single<String> getLatestPatchVersion();
}
