package de.g00fy2.justdoit.app.fragments.leagueposition;

import dagger.Component;
import de.g00fy2.justdoit.app.di.components.ActivityComponent;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

@PerFragment @Component(dependencies = ActivityComponent.class, modules = LeaguePositionModule.class)
public interface LeaguePositionComponent {

  void inject(LeaguePositionFragment view);

  void inject(LeaguePositionPresenterImpl presenter);
}
