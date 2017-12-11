package de.g00fy2.justdoit.app.di.modules;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.justdoit.BuildConfig;
import de.g00fy2.model.api.APIKeyInterceptor;
import de.g00fy2.model.api.RiotApi;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

@Module public class ApiModule {

  @Provides @Singleton public RiotApi provideRiotApi(Retrofit retrofit) {
    return retrofit.create(RiotApi.class);
  }

  @Provides @Singleton public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl("https://euw1.api.riotgames.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }

  @Provides @Singleton
  public OkHttpClient provideOkHttpClient(APIKeyInterceptor apiKeyInterceptor) {
    OkHttpClient.Builder okHttpClientBuilder =
        new OkHttpClient.Builder().addInterceptor(apiKeyInterceptor);

    if (BuildConfig.DEBUG) {
      okHttpClientBuilder.addNetworkInterceptor(
          new HttpLoggingInterceptor(message -> Timber.d(message)).setLevel(
              HttpLoggingInterceptor.Level.BODY));
    }

    return okHttpClientBuilder.build();
  }

  @Provides @Singleton public APIKeyInterceptor provideAPIKeyInterceptor() {
    return new APIKeyInterceptor(BuildConfig.API_KEY);
  }
}
