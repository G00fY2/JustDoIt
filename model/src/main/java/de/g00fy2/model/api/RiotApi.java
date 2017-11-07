package de.g00fy2.model.api;

import de.g00fy2.model.entities.web.SummonerWebEntity;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

public interface RiotApi {

  // StaticData

  @GET("lol/static-data/v3/versions") Single<List<String>> getVersions();

  // Summoner

  @GET("/lol/summoner/v3/summoners/by-name/{summonerName}")
  Single<SummonerWebEntity> getSummonerByName(@Path("summonerName") String summonerName);
}
