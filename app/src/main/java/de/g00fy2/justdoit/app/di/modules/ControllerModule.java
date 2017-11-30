package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.ErrorControllerImpl;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.controllers.ImageLoaderControllerImpl;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.controllers.SnackbarControllerImpl;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.controllers.MoshiController;
import de.g00fy2.model.controllers.MoshiControllerImpl;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

@Module public class ControllerModule {

  @Provides @PerActivity
  public MoshiController provideMoshiController(MoshiControllerImpl moshiControllerImpl) {
    return moshiControllerImpl;
  }

  @Provides @PerActivity
  public ErrorController provideErrorController(ErrorControllerImpl errorControllerImpl) {
    return errorControllerImpl;
  }

  @Provides @PerActivity public SnackbarController provideSnackbarController(
      SnackbarControllerImpl snackbarControllerImpl) {
    return snackbarControllerImpl;
  }

  @Provides @PerActivity ImageLoaderController provideImageLoaderController(
      ImageLoaderControllerImpl imageLoaderControllerImpl) {
    return imageLoaderControllerImpl;
  }
}
