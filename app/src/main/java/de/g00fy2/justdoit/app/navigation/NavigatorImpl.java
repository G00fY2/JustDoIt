package de.g00fy2.justdoit.app.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.fragments.matchhistory.DaggerMatchhistoryComponent;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryComponent;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryFragment;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryModule;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryPresenterImpl;
import de.g00fy2.justdoit.app.fragments.start.DaggerStartComponent;
import de.g00fy2.justdoit.app.fragments.start.StartComponent;
import de.g00fy2.justdoit.app.fragments.start.StartFragment;
import de.g00fy2.justdoit.app.fragments.start.StartModule;
import de.g00fy2.justdoit.app.fragments.start.StartPresenterImpl;
import de.g00fy2.model.models.Summoner;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class NavigatorImpl implements Navigator {

  private BaseActivity baseActivity;

  @Inject public NavigatorImpl(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @Override public void showStartFragment() {
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

  @Override public void showMatchhistoryFragment(Summoner summoner) {
    MatchhistoryFragment fragment = new MatchhistoryFragment();
    MatchhistoryPresenterImpl presenter = new MatchhistoryPresenterImpl();
    presenter.setSummoner(summoner);
    MatchhistoryComponent component = DaggerMatchhistoryComponent.builder()
        .activityComponent(baseActivity.getActivityComponent())
        .matchhistoryModule(new MatchhistoryModule(fragment, presenter))
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
      fm.beginTransaction().replace(baseActivity.getFragmentContainerId(), fragment, tag).commit();
    }
  }
}
