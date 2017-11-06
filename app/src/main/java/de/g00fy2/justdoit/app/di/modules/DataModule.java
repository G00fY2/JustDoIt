package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.datasources.web.StaticDataWebDataSource;
import de.g00fy2.model.datasources.web.StaticDataWebDataSourceImpl;
import de.g00fy2.model.datastores.StaticDataStore;
import de.g00fy2.model.datastores.StaticDataStoreImpl;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

@Module public class DataModule {

  // DataSources

  @Provides @PerActivity public StaticDataWebDataSource provideStaticDataWebSource(
      StaticDataWebDataSourceImpl staticDataWebDataSourceImpl) {
    return staticDataWebDataSourceImpl;
  }

  // DataStores

  @Provides @PerActivity public StaticDataStore provideStaticDataStore(
      StaticDataStoreImpl staticDataStoreImpl) {
    return staticDataStoreImpl;
  }
}
