package de.g00fy2.justdoit.app.fragments.start.interactors;

import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface GetVersionsInteractor {

  Single<List<String>> execute();
}
