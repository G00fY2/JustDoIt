package de.g00fy2.justdoit.app.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.navigation.Navigator;
import de.g00fy2.justdoit.app.navigation.NavigatorImpl;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.activities.NavigationDrawer;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Module public class ActivityModule {

  private BaseActivity activity;

  public ActivityModule(BaseActivity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity BaseActivity provideBaseActivity() {
    return activity;
  }

  @Provides @PerActivity Context provideContext() {
    return activity;
  }

  @Provides @PerActivity Navigator provideNavigator() {
    return new NavigatorImpl(activity);
  }

  @Provides @PerActivity NavigationDrawer provideNavigationDrawerHelper() {
    return new NavigationDrawer(activity);
  }
}
