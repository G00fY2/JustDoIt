package de.g00fy2.model.datasources.web;

import io.reactivex.Single;
import java.util.List;

/**
 * Created by Thomas Wirth on 05.11.2017.
 */

public interface StaticDataWebDataSource {

  Single<List<String>> getVersions();
}
