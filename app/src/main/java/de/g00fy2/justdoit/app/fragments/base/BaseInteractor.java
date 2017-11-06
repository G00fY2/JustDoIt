package de.g00fy2.justdoit.app.fragments.base;

import de.g00fy2.model.schedulers.SingleScheduler;
import io.reactivex.SingleTransformer;

/**
 * Created by Thomas Wirth on 06.11.2017.
 */

public class BaseInteractor {
  protected <T> SingleTransformer<T, T> single() {
    return new SingleScheduler<>();
  }
}
