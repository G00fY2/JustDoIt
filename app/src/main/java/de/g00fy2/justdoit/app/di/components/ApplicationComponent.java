package de.g00fy2.justdoit.app.di.components;

import dagger.Component;
import de.g00fy2.justdoit.app.MyApplication;
import de.g00fy2.justdoit.app.di.modules.ApiModule;
import de.g00fy2.justdoit.app.di.modules.ApplicationModule;
import de.g00fy2.model.api.RiotApi;
import javax.inject.Singleton;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Singleton @Component(modules = { ApplicationModule.class, ApiModule.class })
public interface ApplicationComponent {

  MyApplication application();

  RiotApi riotApi();
}
