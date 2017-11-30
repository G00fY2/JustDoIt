package de.g00fy2.model.datasources.local;

import android.content.SharedPreferences;
import io.reactivex.Completable;
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

  @Override public Completable setLatestPatchVersion(String version) {
    return Completable.create(emitter -> {
      sharedPreferences.edit().putString(PATCH_VERSION, version).apply();
      emitter.onComplete();
    });
  }

  @Override public String getLatestPatchVersion() {
    return sharedPreferences.getString(PATCH_VERSION, "7.23.1");
  }
}
