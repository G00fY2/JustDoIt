package de.g00fy2.model.api;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Thomas Wirth on 11.12.2017.
 */

public class APIKeyInterceptor implements Interceptor {
  private String apiKey;

  public APIKeyInterceptor(String apiKey) {
    this.apiKey = apiKey;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    HttpUrl url = request.url().newBuilder().addQueryParameter("api_key", apiKey).build();
    request = request.newBuilder().url(url).build();
    return chain.proceed(request);
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }
}