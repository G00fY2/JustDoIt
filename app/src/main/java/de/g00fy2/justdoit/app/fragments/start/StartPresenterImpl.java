package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class StartPresenterImpl extends BasePresenterImpl implements StartContract.StartPresenter {

  @Inject StartContract.StartView view;

  @Inject public StartPresenterImpl() {

  }
}
