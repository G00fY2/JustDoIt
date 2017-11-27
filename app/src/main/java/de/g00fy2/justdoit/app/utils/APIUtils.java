package de.g00fy2.justdoit.app.utils;

/**
 * Created by Thomas Wirth on 08.11.2017.
 */

public class APIUtils {

  private final static String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/";
  // TODO dynamically update latest version
  private static String latestVersion = "7.23.1";

  public static String generateProfileImageUrl(int iconId) {
    String url = BASE_URL + latestVersion + "/img/profileicon/";
    return url + String.valueOf(iconId) + ".png";
  }

  public static String generateChampionImageUrl(String name) {
    String url = BASE_URL + latestVersion + "/img/champion/";
    return url + name + ".png";
  }
}
