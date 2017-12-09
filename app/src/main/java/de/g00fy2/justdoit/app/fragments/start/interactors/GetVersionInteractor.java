package de.g00fy2.justdoit.app.fragments.start.interactors;

import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface GetVersionInteractor {

  Single<String> execute();
}
