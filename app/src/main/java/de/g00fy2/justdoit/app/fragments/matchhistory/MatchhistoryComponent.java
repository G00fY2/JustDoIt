package de.g00fy2.justdoit.app.fragments.matchhistory;

import dagger.Component;
import de.g00fy2.justdoit.app.di.components.ActivityComponent;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

@PerFragment @Component(dependencies = ActivityComponent.class, modules = MatchhistoryModule.class)
public interface MatchhistoryComponent {

  void inject(MatchhistoryFragment view);

  void inject(MatchhistoryPresenterImpl presenter);
}
