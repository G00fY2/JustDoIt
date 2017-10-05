package de.g00fy2.justdoit.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.fragments.start.DaggerStartComponent;
import de.g00fy2.justdoit.app.fragments.start.StartComponent;
import de.g00fy2.justdoit.app.fragments.start.StartFragment;
import de.g00fy2.justdoit.app.fragments.start.StartModule;
import de.g00fy2.justdoit.app.fragments.start.StartPresenterImpl;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class Navigator {

  private BaseActivity baseActivity;

  public Navigator(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  public void showStartFragment() {
    StartFragment fragment = new StartFragment();
    StartPresenterImpl presenter = new StartPresenterImpl();
    StartComponent component = DaggerStartComponent.builder()
        .activityComponent(baseActivity.getActivityComponent())
        .startModule(new StartModule(fragment, presenter))
        .build();

    component.inject(fragment);
    component.inject(presenter);

    transist(fragment, false);
  }

  private void transist(Fragment fragment, boolean addToBackStack) {
    String tag = fragment.getClass().getName();
    FragmentManager fm = baseActivity.getSupportFragmentManager();

    if (addToBackStack) {
      fm.beginTransaction()
          .replace(baseActivity.getFragmentContainerId(), fragment, tag)
          .addToBackStack(tag)
          .commit();
    } else {
      fm.beginTransaction()
          .replace(baseActivity.getFragmentContainerId(), fragment, tag)
          .commit();
    }
  }
}
