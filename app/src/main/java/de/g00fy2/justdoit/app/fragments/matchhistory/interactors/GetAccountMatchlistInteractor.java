package de.g00fy2.justdoit.app.fragments.matchhistory.interactors;

import de.g00fy2.model.models.Match;
import io.reactivex.Observable;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface GetAccountMatchlistInteractor {

  Observable<Match> execute(String accountId);
}
