package de.g00fy2.model.utils;

/**
 * Created by Thomas Wirth on 07.12.2017.
 */

public class LeagueUtils {

  public static int transformRankToInteger(String rank) {
    switch (rank) {
      case "I":
        return 1;
      case "II":
        return 2;
      case "III":
        return 3;
      case "IV":
        return 4;
      case "V":
        return 5;
      default:
        return 0;
    }
  }

  public static String transformRankToString(int rank) {
    switch (rank) {
      case 1:
        return "I";
      case 2:
        return "II";
      case 3:
        return "III";
      case 4:
        return "IV";
      case 5:
        return "V";
      default:
        return "";
    }
  }
}
