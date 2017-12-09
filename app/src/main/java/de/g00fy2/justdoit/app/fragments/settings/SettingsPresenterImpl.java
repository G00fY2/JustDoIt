package de.g00fy2.justdoit.app.fragments.settings;

import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.settings.interactors.GetCurrentVersionInteractor;
import de.g00fy2.justdoit.app.navigation.NavigationDrawer;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

public class SettingsPresenterImpl extends BasePresenterImpl
    implements SettingsContract.SettingsPresenter {

  @Inject SettingsContract.SetingsView view;

  @Inject NavigationDrawer navigationDrawer;
  @Inject GetCurrentVersionInteractor getCurrentVersionInteractor;
  @Inject SnackbarController snackbarController;
  @Inject ErrorController errorController;

  @Inject public SettingsPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();
    navigationDrawer.setCheckedItem(R.id.settings);
    bind(getCurrentVersionInteractor.execute()
        .subscribe(currentVersion -> view.setPatchversionPreference(currentVersion),
            errorController::onError));
  }

  @Override public void showNotAvailableNotice() {
    snackbarController.showError("Setting currently not available.");
  }
}
