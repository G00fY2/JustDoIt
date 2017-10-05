package de.g00fy2.justdoit.app.fragments.start;

import dagger.Component;
import de.g00fy2.justdoit.app.annotations.PerFragment;
import de.g00fy2.justdoit.app.di.ActivityComponent;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerFragment @Component(dependencies = ActivityComponent.class, modules = StartModule.class)
public interface StartComponent {

  void inject(StartFragment view);

  void inject(StartPresenterImpl presenter);
}
