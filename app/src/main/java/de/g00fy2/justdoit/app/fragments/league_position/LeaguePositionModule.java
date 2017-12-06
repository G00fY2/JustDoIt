package de.g00fy2.justdoit.app.fragments.league_position;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerFragment;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeagueItemsDataInteractor;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeagueItemsDataInteractorImpl;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeaguePositionsDataInteractor;
import de.g00fy2.justdoit.app.fragments.league_position.interactors.GetLeaguePositionsDataInteractorImpl;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

@Module public class LeaguePositionModule {

  private LeaguePositionContract.LeaguePositionView view;
  private LeaguePositionContract.LeaguePositionPresenter presenter;

  public LeaguePositionModule(LeaguePositionContract.LeaguePositionView view,
      LeaguePositionContract.LeaguePositionPresenter presenter) {
    this.presenter = presenter;
    this.view = view;
  }

  @Provides @PerFragment LeaguePositionContract.LeaguePositionView provideView() {
    return view;
  }

  @Provides @PerFragment LeaguePositionContract.LeaguePositionPresenter providePresenter() {
    return presenter;
  }

  @Provides @PerFragment GetLeaguePositionsDataInteractor provideGetLeaguePositionsDataInteractor(
      GetLeaguePositionsDataInteractorImpl getLeaguePositionsDataInteractorImpl) {
    return getLeaguePositionsDataInteractorImpl;
  }

  @Provides @PerFragment GetLeagueItemsDataInteractor provideGetLeagueItemsDataInteractor(
      GetLeagueItemsDataInteractorImpl getLeagueItemsDataInteractorImpl) {
    return getLeagueItemsDataInteractorImpl;
  }
}
