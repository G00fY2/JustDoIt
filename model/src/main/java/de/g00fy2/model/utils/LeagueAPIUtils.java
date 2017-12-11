package de.g00fy2.model.utils;

import de.g00fy2.model.models.Participant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thomas Wirth on 07.12.2017.
 */

public class LeagueAPIUtils {

  private static final String RANK1 = "I";
  private static final String RANK2 = "II";
  private static final String RANK3 = "III";
  private static final String RANK4 = "IV";
  private static final String RANK5 = "V";
  private static final String UNKNOWN = "Unkown queue type";
  private static final Map<Integer, String> queueTypes = createQueueMap();

  public static int transformRankToInteger(String rank) {
    switch (rank) {
      case RANK1:
        return 1;
      case RANK2:
        return 2;
      case RANK3:
        return 3;
      case RANK4:
        return 4;
      case RANK5:
        return 5;
      default:
        return 0;
    }
  }

  public static String transformRankToString(int rank) {
    switch (rank) {
      case 1:
        return RANK1;
      case 2:
        return RANK2;
      case 3:
        return RANK3;
      case 4:
        return RANK4;
      case 5:
        return RANK5;
      default:
        return "";
    }
  }

  public static String queueIdToGamemode(int queueId) {
    return queueTypes.get(queueId) != null ? queueTypes.get(queueId) : UNKNOWN;
  }

  public static String transfromGameDuration(long gameDuration) {
    return String.valueOf(Math.round(gameDuration / 60));
  }

  public static String buildKDAString(Participant participant) {
    StringBuilder sb = new StringBuilder();
    sb.append(participant.kills);
    sb.append("/");
    sb.append(participant.deaths);
    sb.append("/");
    sb.append(participant.assists);
    return sb.toString();
  }

  private static Map<Integer, String> createQueueMap() {
    Map<Integer, String> result = new HashMap<>();
    result.put(0, "Custom");
    result.put(400, "5v5 Draft Pick");
    result.put(420, "5v5 Ranked Solo");
    result.put(430, "5v5 Blind Pick");
    result.put(440, "5v5 Ranked Flex");
    result.put(450, "5v5 ARAM");
    result.put(460, "3v3 Blind Pick");
    result.put(470, "3v3 Ranked Flex");
    result.put(470, "3v3 Ranked Flex");
    return Collections.unmodifiableMap(result);
  }
}
