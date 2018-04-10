package de.g00fy2.justdoit.app.fragments.matchhistory;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;
import de.g00fy2.justdoit.app.fragments.matchhistory.interactors.GetAccountMatchlistInteractor;
import de.g00fy2.justdoit.app.fragments.matchhistory.interactors.GetAccountMatchlistInteractorImpl;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

@Module public class MatchhistoryModule {

  private MatchhistoryContract.MatchhistoryView view;
  private MatchhistoryContract.MatchhistoryPresenter presenter;

  public MatchhistoryModule(MatchhistoryContract.MatchhistoryView view, MatchhistoryContract.MatchhistoryPresenter presenter) {
    this.view = view;
    this.presenter = presenter;
  }

  @Provides @PerFragment MatchhistoryContract.MatchhistoryView provideView() {
    return view;
  }

  @Provides @PerFragment MatchhistoryContract.MatchhistoryPresenter providePresenter() {
    return presenter;
  }

  @Provides @PerFragment public GetAccountMatchlistInteractor provideGetAccountMatchlistInteractor(
      GetAccountMatchlistInteractorImpl getAccountMatchlistInteractorImpl) {
    return getAccountMatchlistInteractorImpl;
  }
}
