package de.g00fy2.justdoit.app.di.components;

import android.content.Context;
import dagger.Component;
import de.g00fy2.justdoit.app.Navigator;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.activities.NavigationDrawer;
import de.g00fy2.justdoit.app.controllers.ErrorController;
import de.g00fy2.justdoit.app.controllers.SnackbarController;
import de.g00fy2.justdoit.app.di.modules.ActivityModule;
import de.g00fy2.justdoit.app.di.modules.ControllerModule;
import de.g00fy2.justdoit.app.di.modules.DataModule;
import de.g00fy2.justdoit.app.di.modules.TransformerModule;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.controllers.MoshiController;
import de.g00fy2.model.datastores.MatchDataStore;
import de.g00fy2.model.datastores.StaticDataDataStore;
import de.g00fy2.model.datastores.SummonerDataStore;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerActivity @Component(modules = {
    ActivityModule.class, DataModule.class, ControllerModule.class, TransformerModule.class
}, dependencies = ApplicationComponent.class) public interface ActivityComponent {

  BaseActivity baseActivity();

  Context context();

  Navigator navigator();

  NavigationDrawer navigationDrawer();

  // Controllers

  MoshiController moshiController();

  ErrorController errorController();

  SnackbarController snackbarController();

  // DataStores

  StaticDataDataStore staticDataStore();

  SummonerDataStore summonerDataStore();

  MatchDataStore matchlistDataStore();
}
