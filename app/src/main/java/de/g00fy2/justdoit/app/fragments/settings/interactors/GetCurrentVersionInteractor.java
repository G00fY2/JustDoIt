package de.g00fy2.justdoit.app.fragments.settings.interactors;

import io.reactivex.Single;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public interface GetCurrentVersionInteractor {

  Single<String> execute();
}
