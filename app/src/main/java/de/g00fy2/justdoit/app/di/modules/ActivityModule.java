package de.g00fy2.justdoit.app.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.activities.NavigationDrawer;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.justdoit.app.navigation.Navigator;
import de.g00fy2.justdoit.app.navigation.NavigatorImpl;
import de.g00fy2.model.datasources.local.SharedPreferencesDataSourceImpl;

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

  @Provides @PerActivity public SharedPreferences provideSharedPreferences() {
    return activity.getSharedPreferences(SharedPreferencesDataSourceImpl.PREF_FILE_NAME,
        Context.MODE_PRIVATE);
  }
}
