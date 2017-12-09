package de.g00fy2.justdoit.app.fragments.start.interactors;

import io.reactivex.Completable;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public interface DeleteStoredSummonerInteractor {

  Completable execute(long id);
}
