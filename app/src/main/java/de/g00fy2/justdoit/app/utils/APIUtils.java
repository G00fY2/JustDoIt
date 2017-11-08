package de.g00fy2.justdoit.app.utils;

/**
 * Created by Thomas Wirth on 08.11.2017.
 */

public class APIUtils {

  public static String generateProfileIconUrl(int iconId) {
    // TODO add to constants and dynamically update version path
    String url = "http://ddragon.leagueoflegends.com/cdn/7.21.1/img/profileicon/";

    return url + String.valueOf(iconId) + ".png";
  }
}
