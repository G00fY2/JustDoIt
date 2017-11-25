package de.g00fy2.model.controllers;

import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 01.11.2017.
 */

public interface MoshiController {

  <T> Single<T> fromJson(String json, Class<T> type);

  <T> Single<String> toJson(T obj, Class<T> type);
}
