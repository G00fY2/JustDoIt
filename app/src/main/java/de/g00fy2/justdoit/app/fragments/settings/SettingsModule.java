package de.g00fy2.justdoit.app.fragments.settings;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;
import de.g00fy2.justdoit.app.fragments.settings.interactors.GetCurrentVersionInteractor;
import de.g00fy2.justdoit.app.fragments.settings.interactors.GetCurrentVersionInteractorImpl;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

@Module public class SettingsModule {

  private SettingsContract.SetingsView view;
  private SettingsContract.SettingsPresenter presenter;

  public SettingsModule(SettingsContract.SetingsView view,
      SettingsContract.SettingsPresenter presenter) {
    this.presenter = presenter;
    this.view = view;
  }

  @Provides @PerFragment SettingsContract.SetingsView provideView() {
    return view;
  }

  @Provides @PerFragment SettingsContract.SettingsPresenter providePresenter() {
    return presenter;
  }

  @Provides @PerFragment public GetCurrentVersionInteractor provideGetCurrentVersionInteractor(
      GetCurrentVersionInteractorImpl getCurrentVersionInteractorImpl) {
    return getCurrentVersionInteractorImpl;
  }
}
