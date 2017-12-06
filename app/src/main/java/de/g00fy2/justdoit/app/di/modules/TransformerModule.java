package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.app.di.scopes.PerActivity;
import de.g00fy2.model.transformers.ChampionListTransformer;
import de.g00fy2.model.transformers.ChampionListTransformerImpl;
import de.g00fy2.model.transformers.LeagueItemTransformer;
import de.g00fy2.model.transformers.LeagueItemTransformerImpl;
import de.g00fy2.model.transformers.LeagueListTransformer;
import de.g00fy2.model.transformers.LeagueListTransformerImpl;
import de.g00fy2.model.transformers.LeaguePositionTransformer;
import de.g00fy2.model.transformers.LeaguePositionTransformerImpl;
import de.g00fy2.model.transformers.MatchTransformer;
import de.g00fy2.model.transformers.MatchTransformerImpl;
import de.g00fy2.model.transformers.MatchlistTransformer;
import de.g00fy2.model.transformers.MatchlistTransformerImpl;
import de.g00fy2.model.transformers.SummonerSpellTransformer;
import de.g00fy2.model.transformers.SummonerSpellTransformerImpl;
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

  @Provides @PerActivity
  public MatchTransformer provideMatchTransformer(MatchTransformerImpl matchTransformerImpl) {
    return matchTransformerImpl;
  }

  @Provides @PerActivity public LeagueListTransformer provideLeagueListTransformer(
      LeagueListTransformerImpl leagueListTransformerImpl) {
    return leagueListTransformerImpl;
  }

  @Provides @PerActivity public LeagueItemTransformer provideLeagueItemTransformer(
      LeagueItemTransformerImpl leagueItemTransformerImpl) {
    return leagueItemTransformerImpl;
  }

  @Provides @PerActivity public LeaguePositionTransformer provideLeaguePositionTransformer(
      LeaguePositionTransformerImpl leaguePositionTransformerImpl) {
    return leaguePositionTransformerImpl;
  }

  @Provides @PerActivity public ChampionListTransformer provideChampionListTransformer(
      ChampionListTransformerImpl championListTransformerImpl) {
    return championListTransformerImpl;
  }

  @Provides @PerActivity public SummonerSpellTransformer provideSummonerSpellTransformer(
      SummonerSpellTransformerImpl summonerSpellTransformerImpl) {
    return summonerSpellTransformerImpl;
  }
}
