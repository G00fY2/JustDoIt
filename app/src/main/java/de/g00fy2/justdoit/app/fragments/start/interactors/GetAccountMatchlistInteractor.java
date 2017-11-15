package de.g00fy2.justdoit.app.fragments.start.interactors;

import de.g00fy2.model.models.Matchlist;
import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 15.11.2017.
 */

public interface GetAccountMatchlistInteractor {

  Single<Matchlist> execute(String accountId);
}
