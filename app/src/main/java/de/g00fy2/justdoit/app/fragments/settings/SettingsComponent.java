package de.g00fy2.justdoit.app.fragments.settings;

import dagger.Component;
import de.g00fy2.justdoit.app.di.components.ActivityComponent;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

@PerFragment @Component(dependencies = ActivityComponent.class, modules = SettingsModule.class)
public interface SettingsComponent {

  void inject(SettingsFragment view);

  void inject(SettingsPresenterImpl presenter);
}
