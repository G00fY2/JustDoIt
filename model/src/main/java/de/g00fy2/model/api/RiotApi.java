package de.g00fy2.model.api;

import de.g00fy2.model.entities.web.LeagueListWebEntity;
import de.g00fy2.model.entities.web.LeaguePositionWebEntity;
import de.g00fy2.model.entities.web.MatchWebEntity;
import de.g00fy2.model.entities.web.MatchlistWebEntity;
import de.g00fy2.model.entities.web.SummonerWebEntity;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

public interface RiotApi {

  // LOL-STATIC-DATA-V3

  @GET("lol/static-data/v3/versions") Single<List<String>> getVersions();

  // SUMMONER-V3

  @GET("/lol/summoner/v3/summoners/by-name/{summonerName}")
  Single<SummonerWebEntity> getSummonerByName(@Path("summonerName") String summonerName);

  @GET("/lol/summoner/v3/summoners/by-account/{accountId}")
  Single<SummonerWebEntity> getSummonerByAccountId(@Path("accountId") String accountId);

  // MATCH-V3

  @GET("/lol/match/v3/matches/{matchId}") Single<MatchWebEntity> getMatchByMatchId(
      @Path("matchId") String matchId);

  @GET("/lol/match/v3/matchlists/by-account/{accountId}")
  Single<MatchlistWebEntity> getMatchlistByAccountId(@Path("accountId") String accountId,
      @Query("queue") Set<Integer> queue, @Query("season") Integer season);

  @GET("/lol/match/v3/matchlists/by-account/{accountId}/recent")
  Single<MatchlistWebEntity> getMatchlistByAccountIdRecent(@Path("accountId") String accountId);

  // LEAGUE-V3

  @GET("/lol/league/v3/positions/by-summoner/{summonerId}")
  Single<Set<LeaguePositionWebEntity>> getLeaguePositions(@Path("summonerId") String summonerId);

  @GET("/lol/league/v3/leagues/{leagueId}")
  Single<LeagueListWebEntity> getLeagueLists(@Path("leagueId") String leagueId);
}
