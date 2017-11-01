package de.g00fy2.model.api;

import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Thomas on 01.11.2017.
 */

public interface RiotApi {

  @GET("lol/static-data/v3/versions") Single<List<String>> getVersions(@Query("api_key") String apiKey);
}
