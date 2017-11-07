package de.g00fy2.justdoit.app.controllers;

import android.support.design.widget.Snackbar;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class SnackbarControllerImpl implements SnackbarController {

  @Inject BaseActivity baseActivity;

  @Inject public SnackbarControllerImpl() {

  }

  //TODO define color
  @Override public void showError(String message) {
    Snackbar.make(baseActivity.getFragmentContainer(), message, Snackbar.LENGTH_LONG).show();
  }

  //TODO define color
  @Override public void showSuccess(String message) {

    Snackbar.make(baseActivity.getFragmentContainer(), message, Snackbar.LENGTH_LONG).show();
  }
}
