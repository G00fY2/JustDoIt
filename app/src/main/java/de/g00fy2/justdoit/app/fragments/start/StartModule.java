package de.g00fy2.justdoit.app.fragments.start;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetStaticDataVersionsInteractor;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetStaticDataVersionsInteractorImpl;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerFragment @Module public class StartModule {

  private StartContract.StartView view;
  private StartContract.StartPresenter presenter;

  public StartModule(StartContract.StartView view, StartContract.StartPresenter presenter) {
    this.view = view;
    this.presenter = presenter;
  }

  @Provides @PerFragment StartContract.StartView provideView() {
    return view;
  }

  @Provides @PerFragment StartContract.StartPresenter providePresenter() {
    return presenter;
  }

  @Provides @PerFragment
  public GetStaticDataVersionsInteractor provideGetStaticDataVersionsInteractor(
      GetStaticDataVersionsInteractorImpl getStaticDataVersionsInteractorImpl) {
    return getStaticDataVersionsInteractorImpl;
  }
}
