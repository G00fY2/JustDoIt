package de.g00fy2.model.di;

import dagger.Module;
import dagger.Provides;
import de.g00fy2.model.api.RiotApi;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Thomas on 01.11.2017.
 */

@Module public class ApiModule {

  @Provides @Singleton public RiotApi provideRiotApi(Retrofit retrofit) {
    return retrofit.create(RiotApi.class);
  }

  @Provides @Singleton public Retrofit provideRetrofit() {
    return new Retrofit.Builder().baseUrl("https://euw1.api.riotgames.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
