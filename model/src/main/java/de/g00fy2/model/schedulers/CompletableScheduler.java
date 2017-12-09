package de.g00fy2.model.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

public class CompletableScheduler implements CompletableTransformer {

  @Override public CompletableSource apply(Completable upstream) {
    return upstream.subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
