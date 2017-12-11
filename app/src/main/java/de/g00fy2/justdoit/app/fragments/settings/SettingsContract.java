package de.g00fy2.justdoit.app.fragments.settings;

import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.justdoit.app.fragments.base.BaseView;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

public interface SettingsContract {

  interface SettingsPresenter extends BasePresenter {

    void showNotAvailableNotice();

    void changeAPIKey(String newAPIKey);
  }

  interface SetingsView extends BaseView {

    void setPatchversionPreference(String version);
  }
}
