package de.g00fy2.justdoit.app.fragments.tab1;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.annotations.PerFragment;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerFragment @Module public class Tab1Module {

  private Tab1Contract.StartView view;
  private Tab1Contract.StartPresenter presenter;

  public Tab1Module(Tab1Contract.StartView view, Tab1Contract.StartPresenter presenter) {
    this.view = view;
    this.presenter = presenter;
  }

  @Provides @PerFragment Tab1Contract.StartView provideView() {
    return view;
  }

  @Provides @PerFragment Tab1Contract.StartPresenter providePresenter() {
    return presenter;
  }
}
