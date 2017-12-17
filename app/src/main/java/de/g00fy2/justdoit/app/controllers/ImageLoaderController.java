package de.g00fy2.justdoit.app.controllers;

import android.widget.ImageView;
import io.reactivex.Completable;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public interface ImageLoaderController {

  Completable setLatestVersion(String latestVersion);

  void loadProfileIcon(int profileIconId, ImageView imageView, Boolean circleCrop);

  void loadChampionIcon(String championKey, ImageView imageView, Boolean circleCrop);

  void loadSpellIcon(String spellKey, ImageView imageView, Boolean circleCrop);

  void loadDivisionIcon(String tier, int rank, ImageView imageView);
}
