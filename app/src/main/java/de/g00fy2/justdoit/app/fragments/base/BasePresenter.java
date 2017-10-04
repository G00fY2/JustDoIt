package de.g00fy2.justdoit.app.fragments.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public interface BasePresenter {

  void bind(Disposable subscription);

  void onCreate();

  void onResume();

  void onPause();

}
