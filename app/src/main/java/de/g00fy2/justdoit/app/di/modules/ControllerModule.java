package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
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
}
