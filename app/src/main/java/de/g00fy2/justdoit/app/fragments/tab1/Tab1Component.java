package de.g00fy2.justdoit.app.fragments.tab1;

import dagger.Component;
import de.g00fy2.justdoit.app.annotations.PerFragment;
import de.g00fy2.justdoit.app.di.ActivityComponent;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerFragment @Component(dependencies = ActivityComponent.class, modules = Tab1Module.class)
public interface Tab1Component {

  void inject(Tab1Fragment view);

  void inject(Tab1PresenterImpl presenter);
}
