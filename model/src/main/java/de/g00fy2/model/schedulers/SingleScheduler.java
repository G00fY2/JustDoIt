package de.g00fy2.model.schedulers;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Thomas Wirth on 06.11.2017.
 */

public class SingleScheduler<T> implements SingleTransformer<T, T> {

  @Override public SingleSource<T> apply(Single<T> upstream) {
    return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
}
