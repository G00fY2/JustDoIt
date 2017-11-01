package de.g00fy2.model.controllers;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import javax.inject.Inject;

/**
 * Created by Thomas on 01.11.2017.
 */

public class MoshiControllerImpl implements MoshiController {

  private Moshi moshi;

  @Inject public MoshiControllerImpl() {
    this.moshi = new Moshi.Builder().build();
  }

  @Override public <T> Single<T> fromJson(String json, Class<T> type) {
    if (json == null || json.length() == 0) {
      json = "{}";
    }
    String finalJson = json;
    return Single.create(singleEmitter -> {
      JsonAdapter<T> jsonAdapter = moshi.adapter(type);
      T obj = jsonAdapter.fromJson(finalJson);
      singleEmitter.onSuccess(obj);
    });
  }

  @Override public <T> Single<String> toJson(T obj, Class<T> type) {
    JsonAdapter<T> jsonAdapter = moshi.adapter(type);
    return Single.just(jsonAdapter.toJson(obj));
  }
}
