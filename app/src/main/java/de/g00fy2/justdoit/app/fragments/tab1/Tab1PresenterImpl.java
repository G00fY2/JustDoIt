package de.g00fy2.justdoit.app.fragments.tab1;

import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class Tab1PresenterImpl extends BasePresenterImpl implements Tab1Contract.StartPresenter {

  @Inject Tab1Contract.StartView view;

  @Inject public Tab1PresenterImpl() {

  }
}
