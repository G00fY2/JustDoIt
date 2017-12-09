package de.g00fy2.justdoit.app.fragments.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import de.g00fy2.justdoit.BuildConfig;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.annotations.Title;
import de.g00fy2.justdoit.app.fragments.base.BasePreferenceFragment;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.model.utils.Constants;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

@Layout(R.layout.fragment_settings) @Title(R.string.settings) public class SettingsFragment
    extends BasePreferenceFragment implements SettingsContract.SetingsView {

  private Preference regionPreference;
  private Preference apikeyPreference;
  private Preference patchversionPreference;
  private Preference appversionPreference;
  private Preference sourcecodePreference;

  @Inject SettingsContract.SettingsPresenter presenter;

  @Override public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    addPreferencesFromResource(R.xml.preferences);
  }

  @Override protected void initializeViews() {
    regionPreference = findPreference("region");
    regionPreference.setOnPreferenceClickListener(preference -> {
      presenter.showNotAvailableNotice();
      return true;
    });
    apikeyPreference = findPreference("apikey");
    apikeyPreference.setOnPreferenceClickListener(preference -> {
      presenter.showNotAvailableNotice();
      return true;
    });
    apikeyPreference.setOnPreferenceChangeListener((preference, newValue) -> {
      presenter.showNotAvailableNotice();
      return true;
    });
    patchversionPreference = findPreference("patchversion");
    patchversionPreference.setSummary("Version: ");
    appversionPreference = findPreference("appversion");
    appversionPreference.setSummary("Version: " + BuildConfig.VERSION_NAME);
    sourcecodePreference = findPreference("sourcecode");
    sourcecodePreference.setOnPreferenceClickListener(preference -> {
      startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(Constants.sourceCodeURL)));
      return true;
    });
  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }

  @Override public void setPatchversionPreference(String version) {
    if (patchversionPreference != null) {
      patchversionPreference.setSummary("Version: " + version);
    }
  }
}
