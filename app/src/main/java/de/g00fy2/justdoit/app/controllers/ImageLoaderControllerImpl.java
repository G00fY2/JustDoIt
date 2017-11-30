package de.g00fy2.justdoit.app.controllers;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public class ImageLoaderControllerImpl implements ImageLoaderController {

  private final BaseActivity baseActivity;
  private final String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/";
  private String latestVersion = "7.23.1";

  @Inject public ImageLoaderControllerImpl(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @Override public void setLatestVersion(String latestVersion) {
    this.latestVersion = latestVersion;
  }

  @Override
  public void loadProfileIcon(int profileIconId, ImageView imageView, Boolean circleCrop) {
    String url = generateProfileImageUrl(profileIconId);
    if (circleCrop) {
      loadCircleTransformed(url).into(imageView);
    } else {
      load(url).into(imageView);
    }
  }

  @Override public void loadChampionIcon(String name, ImageView imageView, Boolean circleCrop) {
    String url = generateChampionImageUrl(name);
    if (circleCrop) {
      loadCircleTransformed(url).into(imageView);
    } else {
      load(url).into(imageView);
    }
  }

  private RequestBuilder<Drawable> load(String url) {
    return Glide.with(baseActivity).load(url);
  }

  private RequestBuilder<Drawable> loadCircleTransformed(String url) {
    return Glide.with(baseActivity).load(url).apply(RequestOptions.circleCropTransform());
  }

  private String generateProfileImageUrl(int iconId) {
    String url = BASE_URL + latestVersion + "/img/profileicon/";
    return url + String.valueOf(iconId) + ".png";
  }

  private String generateChampionImageUrl(String name) {
    String url = BASE_URL + latestVersion + "/img/champion/";
    return url + name + ".png";
  }
}
