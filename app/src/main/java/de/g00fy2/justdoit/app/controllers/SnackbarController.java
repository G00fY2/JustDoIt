package de.g00fy2.justdoit.app.controllers;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public interface SnackbarController {

  void showError(String message);

  void showSuccess(String message);
}
