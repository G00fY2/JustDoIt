package de.g00fy2.justdoit.app.controllers;

import java.io.IOException;
import javax.inject.Inject;
import retrofit2.HttpException;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public class ErrorControllerImpl implements ErrorController {

  @Inject SnackbarController snackbarController;

  @Inject public ErrorControllerImpl() {

  }

  @Override public void onError(Throwable throwable) {
    throwable.printStackTrace();

    if (throwable instanceof HttpException) {
      handleHttpError(throwable);
    } else if (throwable instanceof IOException) {
      snackbarController.showError("Network error");
    } else {
      snackbarController.showError("Unknown error");
    }
  }

  private void handleHttpError(Throwable throwable) {
    //TODO stringify error messages to useful user messages
    HttpException httpException = (HttpException) throwable;
    snackbarController.showError(httpException.code() + " " + httpException.message());
  }
}
