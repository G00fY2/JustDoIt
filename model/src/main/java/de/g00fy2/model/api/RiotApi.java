package de.g00fy2.model.api;

import de.g00fy2.model.entities.web.MatchlistWebEntity;
import de.g00fy2.model.entities.web.SummonerWebEntity;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

public interface RiotApi {

  // LOL-STATIC-DATA-V3

  @GET("lol/static-data/v3/versions") Single<List<String>> getVersions();

  // SUMMONER-V3

  @GET("/lol/summoner/v3/summoners/by-name/{summonerName}")
  Single<SummonerWebEntity> getSummonerByName(@Path("summonerName") String summonerName);

  // MATCH-V3

  @GET("/lol/match/v3/matchlists/by-account/{accountId}")
  Single<MatchlistWebEntity> getMatchlistByAccountId(@Path("accountId") String accountId);
}
