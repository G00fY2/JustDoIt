package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSourceImpl;
import de.g00fy2.model.datasources.web.SummonerWebDataSource;
import de.g00fy2.model.datasources.web.SummonerWebDataSourceImpl;
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

  // DataStores

  @Provides @PerActivity
  public StaticDataDataStore provideStaticDataDataStore(StaticDataDataStoreImpl staticDataDataStoreImpl) {
    return staticDataDataStoreImpl;
  }

  @Provides @PerActivity
  public SummonerDataStore provideSummonerDataStore(SummonerDataStoreImpl summonerDataStoreImpl) {
    return summonerDataStoreImpl;
  }
}
