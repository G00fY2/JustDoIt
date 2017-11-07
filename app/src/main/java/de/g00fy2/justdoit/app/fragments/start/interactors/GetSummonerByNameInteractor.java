package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public interface GetSummonerByNameInteractor {

  Single<Summoner> execute(String summonerName);
}
