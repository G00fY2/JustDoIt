package de.g00fy2.model.schedulers;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Thomas Wirth on 17.11.2017.
 */

public class ObservableScheduler<T> implements ObservableTransformer<T, T> {

  @Override public ObservableSource<T> apply(Observable<T> upstream) {
    return upstream.subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
