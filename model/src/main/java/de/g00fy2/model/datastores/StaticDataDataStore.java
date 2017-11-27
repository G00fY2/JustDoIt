package de.g00fy2.model.datastores;

import de.g00fy2.model.models.Champion;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface StaticDataDataStore {

  Single<List<Champion>> getChampions();

  Single<List<String>> getVersions();
}
