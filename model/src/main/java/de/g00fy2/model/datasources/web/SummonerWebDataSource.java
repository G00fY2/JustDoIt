package de.g00fy2.model.datasources.web;

import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 07.11.2017.
 */

public interface SummonerWebDataSource {

  Single<Summoner> getSummonerByName(String summonerName);
}
