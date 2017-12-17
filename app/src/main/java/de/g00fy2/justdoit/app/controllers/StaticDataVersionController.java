package de.g00fy2.justdoit.app.controllers;

import io.reactivex.Completable;

/**
 * Created by Thomas Wirth on 14.12.2017.
 */

public interface StaticDataVersionController {

  Completable setupStaticData();
}
