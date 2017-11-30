package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.datasources.local.SharedPreferencesDataSource;
import de.g00fy2.model.datasources.local.SharedPreferencesDataSourceImpl;
import de.g00fy2.model.datasources.web.LeagueWebDataSource;
import de.g00fy2.model.datasources.web.LeagueWebDataSourceImpl;
import de.g00fy2.model.datasources.web.MatchWebDataSource;
import de.g00fy2.model.datasources.web.MatchWebDataSourceImpl;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSourceImpl;
import de.g00fy2.model.datasources.web.SummonerWebDataSource;
import de.g00fy2.model.datasources.web.SummonerWebDataSourceImpl;
import de.g00fy2.model.datastores.LeagueDataStore;
import de.g00fy2.model.datastores.LeagueDataStoreImpl;
import de.g00fy2.model.datastores.MatchDataStore;
import de.g00fy2.model.datastores.MatchDataStoreImpl;
import de.g00fy2.model.datastores.StaticDataDataStore;
import de.g00fy2.model.datastores.StaticDataDataStoreImpl;
import de.g00fy2.model.datastores.SummonerDataStore;
import de.g00fy2.model.datastores.SummonerDataStoreImpl;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

@Module public class DataModule {

  // DataSources

  @Provides @PerActivity public StaticDataWebDataSource provideStaticDataWebDataSource(
      StaticDataWebDataSourceImpl staticDataWebDataSourceImpl) {
    return staticDataWebDataSourceImpl;
  }

  @Provides @PerActivity public SummonerWebDataSource provideSummonerWebDataSource(
      SummonerWebDataSourceImpl summonerWebDataSourceImpl) {
    return summonerWebDataSourceImpl;
  }

  @Provides @PerActivity public MatchWebDataSource provideMatchWebDataSourceImpl(
      MatchWebDataSourceImpl matchWebDataSourceImpl) {
    return matchWebDataSourceImpl;
  }

  @Provides @PerActivity public LeagueWebDataSource provideLeagueWebDataSourceImpl(
      LeagueWebDataSourceImpl leagueWebDataSourceImpl) {
    return leagueWebDataSourceImpl;
  }

  @Provides @PerActivity public SharedPreferencesDataSource provideSharedPreferencesDataSourceImpl(
      SharedPreferencesDataSourceImpl sharedPreferencesDataSourceImpl) {
    return sharedPreferencesDataSourceImpl;
  }

  // DataStores

  @Provides @PerActivity public StaticDataDataStore provideStaticDataDataStore(
      StaticDataDataStoreImpl staticDataDataStoreImpl) {
    return staticDataDataStoreImpl;
  }

  @Provides @PerActivity
  public SummonerDataStore provideSummonerDataStore(SummonerDataStoreImpl summonerDataStoreImpl) {
    return summonerDataStoreImpl;
  }

  @Provides @PerActivity
  public MatchDataStore provideMatchDataStore(MatchDataStoreImpl matchDataStoreImpl) {
    return matchDataStoreImpl;
  }

  @Provides @PerActivity
  public LeagueDataStore provideLeagueDataStore(LeagueDataStoreImpl leagueDataStoreImpl) {
    return leagueDataStoreImpl;
  }
}
