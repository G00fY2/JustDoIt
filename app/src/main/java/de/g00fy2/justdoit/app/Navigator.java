package de.g00fy2.justdoit.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.fragments.tab1.DaggerTab1Component;
import de.g00fy2.justdoit.app.fragments.tab1.Tab1Component;
import de.g00fy2.justdoit.app.fragments.tab1.Tab1Fragment;
import de.g00fy2.justdoit.app.fragments.tab1.Tab1Module;
import de.g00fy2.justdoit.app.fragments.tab1.Tab1PresenterImpl;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class Navigator {

  private BaseActivity baseActivity;

  public Navigator(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  public void showStartFragment() {
    Tab1Fragment fragment = new Tab1Fragment();
    Tab1PresenterImpl presenter = new Tab1PresenterImpl();
    Tab1Component component = DaggerTab1Component.builder()
        .activityComponent(baseActivity.getActivityComponent())
        .tab1Module(new Tab1Module(fragment, presenter))
        .build();

    component.inject(fragment);
    component.inject(presenter);

    transist(fragment, true);
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
