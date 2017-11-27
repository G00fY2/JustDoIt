package de.g00fy2.model.transformers;

import de.g00fy2.model.entities.web.MatchWebEntity;
import de.g00fy2.model.entities.web.ParticipantIdentityWebEntitiy;
import de.g00fy2.model.entities.web.ParticipantWebEntity;
import de.g00fy2.model.entities.web.TeamStatsWebEnitity;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Participant;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 16.11.2017.
 */

public class MatchTransformerImpl implements MatchTransformer {

  @Inject MatchTransformerImpl() {

  }

  @Override public Match toModel(String accountId, MatchWebEntity matchWebEntity) {
    if (matchWebEntity != null) {
      Match match = new Match();
      match.seasonId = matchWebEntity.seasonId;
      match.queueId = matchWebEntity.queueId;
      match.gameId = matchWebEntity.gameId;
      match.gameVersion = matchWebEntity.gameVersion;
      match.platformId = matchWebEntity.platformId;
      match.gameMode = matchWebEntity.gameMode;
      match.mapId = matchWebEntity.mapId;
      match.gameType = matchWebEntity.gameType;
      match.gameDuration = matchWebEntity.gameDuration;
      match.gameCreation = matchWebEntity.gameCreation;
      match.participants = new ArrayList<>();

      if (matchWebEntity.participantIdentities != null
          && matchWebEntity.teams != null
          && matchWebEntity.participants != null) {

        List<ParticipantIdentityWebEntitiy> participantIdentitiesWeb =
            matchWebEntity.participantIdentities;
        List<TeamStatsWebEnitity> teamsWeb = matchWebEntity.teams;
        List<ParticipantWebEntity> participantsWeb = matchWebEntity.participants;

        if (participantIdentitiesWeb.size() == participantsWeb.size()) {

          for (int i = 0; i < participantIdentitiesWeb.size(); i++) {
            Participant participant = new Participant();
            participant.participantId = participantIdentitiesWeb.get(i).participantId;
            participant.summonerName = participantIdentitiesWeb.get(i).player.summonerName;
            participant.accountId = participantIdentitiesWeb.get(i).player.accountId;
            participant.profileIcon = participantIdentitiesWeb.get(i).player.profileIcon;

            if (participantIdentitiesWeb.get(i).participantId.equals(
                participantsWeb.get(i).participantId)) {
              participant.championId = participantsWeb.get(i).championId;
              participant.teamId = participantsWeb.get(i).teamId;
              participant.spell1Id = participantsWeb.get(i).spell1Id;
              participant.spell2Id = participantsWeb.get(i).spell2Id;
              if (participantsWeb.get(i).timeline != null) {
                participant.lane = participantsWeb.get(i).timeline.lane;
              }
              if (participantsWeb.get(i).stats != null) {
                participant.kills = participantsWeb.get(i).stats.kills;
                participant.deaths = participantsWeb.get(i).stats.deaths;
                participant.assists = participantsWeb.get(i).stats.assists;
              }
            }

            for (TeamStatsWebEnitity teamStatsWebEnitity : teamsWeb) {
              if (teamStatsWebEnitity.teamId == participant.teamId) {
                participant.win = teamStatsWebEnitity.win;
                break;
              }
            }

            if (Long.toString(participant.accountId).equals(accountId)) {
              match.win = participant.win;
            }

            match.participants.add(participant);
          }
        }
      }

      return match;
    }

    return null;
  }
}
