package de.g00fy2.model.datasources.local;

import android.content.SharedPreferences;
import de.g00fy2.model.utils.Constants;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public class SharedPreferencesDataSourceImpl implements SharedPreferencesDataSource {

  public static final String PREF_FILE_NAME = "sample_app_prefs";
  private final String PATCH_VERSION = "patch_version";

  @Inject SharedPreferences sharedPreferences;

  @Inject public SharedPreferencesDataSourceImpl() {

  }

  @Override public Single<String> setLatestPatchVersion(String version) {
    return Single.just(version).map(ver -> {
      sharedPreferences.edit().putString(PATCH_VERSION, ver).apply();
      return ver;
    });
  }

  @Override public Single<String> getLatestPatchVersion() {
    return Single.just(sharedPreferences.getString(PATCH_VERSION, Constants.fallbackLolVersion));
  }
}
