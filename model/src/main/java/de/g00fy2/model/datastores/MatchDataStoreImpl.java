package de.g00fy2.model.datastores;

import de.g00fy2.model.datasources.web.MatchWebDataSource;
import de.g00fy2.model.models.Champion;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.models.Matchlist;
import de.g00fy2.model.models.Participant;
import de.g00fy2.model.models.SummonerSpell;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public class MatchDataStoreImpl implements MatchDataStore {

  @Inject MatchWebDataSource matchWebDataSource;
  @Inject StaticDataDataStore staticDataDataStore;

  @Inject public MatchDataStoreImpl() {

  }

  @Override public Single<Matchlist> getMatchlistByAccountId(String accountId) {
    return matchWebDataSource.getMatchlistByAccountId(accountId);
  }

  @Override public Single<Match> getMatchByMatchId(String accountId, String matchId) {
    return Single.zip(matchWebDataSource.getMatchByMatchId(accountId, matchId),
        staticDataDataStore.getChampions(), staticDataDataStore.getSummonerSpells(),
        (match, champions, spells) -> {
          addNames(match, champions, spells);
          return match;
        });
  }

  @Override public Observable<Match> getMatchesByAccountId(String accountId, int count) {
    return matchWebDataSource.getMatchlistByAccountId(accountId)
        .flatMapObservable(matchlist -> Observable.fromIterable(matchlist.matches))
        .flatMapSingle(matchReferenceWebEntity -> getMatchByMatchId(accountId,
            Long.toString(matchReferenceWebEntity.gameId)))
        .take(count);
  }

  private void addNames(Match match, Map<Integer, Champion> championMap, Map<Integer, SummonerSpell> summonerSpellMap) {
    for (Participant participant : match.participants) {
      if (championMap.get(participant.championId) != null) {
        participant.championName = championMap.get(participant.championId).name;
        participant.championKey = championMap.get(participant.championId).key;
        participant.spell1Name = summonerSpellMap.get(participant.spell1Id).name;
        participant.spell1Key = summonerSpellMap.get(participant.spell1Id).key;
        participant.spell2Name = summonerSpellMap.get(participant.spell2Id).name;
        participant.spell2Key = summonerSpellMap.get(participant.spell2Id).key;
      }
    }
  }
}
