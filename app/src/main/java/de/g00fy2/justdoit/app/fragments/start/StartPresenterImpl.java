package de.g00fy2.justdoit.app.fragments.start;

import de.g00fy2.justdoit.app.fragments.base.BasePresenterImpl;
import de.g00fy2.justdoit.app.fragments.start.interactors.GetStaticDataVersionsInteractor;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class StartPresenterImpl extends BasePresenterImpl implements StartContract.StartPresenter {

  @Inject StartContract.StartView view;
  @Inject GetStaticDataVersionsInteractor getStaticDataVersionsInteractor;

  @Inject public StartPresenterImpl() {

  }

  @Override public void onResume() {
    super.onResume();

    bind(getStaticDataVersionsInteractor.execute().subscribe(versionList -> {
      if (versionList != null && versionList.size() > 0) {
        view.showCurrentVersion(versionList.get(0));
      }
    }, Throwable::printStackTrace));
  }
}
