package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.model.models.Summoner;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public interface GetStoredSummonerInteractor {

  Single<List<Summoner>> execute();
}
