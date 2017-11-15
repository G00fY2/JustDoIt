package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.transformers.MatchlistTransformer;
import de.g00fy2.model.transformers.MatchlistTransformerImpl;
import de.g00fy2.model.transformers.SummonerTransformer;
import de.g00fy2.model.transformers.SummonerTransformerImpl;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

@Module public class TransformerModule {

  @Provides @PerActivity public SummonerTransformer provideSummonerTransformer(
      SummonerTransformerImpl summonerTransformerImpl) {
    return summonerTransformerImpl;
  }

  @Provides @PerActivity public MatchlistTransformer provideMatchlistTransformer(
      MatchlistTransformerImpl matchlistTransformerImpl) {
    return matchlistTransformerImpl;
  }
}
