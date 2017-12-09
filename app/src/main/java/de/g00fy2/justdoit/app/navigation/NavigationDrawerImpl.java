package de.g00fy2.justdoit.app.navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.model.models.Summoner;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 19.11.2017.
 */

public class NavigationDrawerImpl
    implements NavigationDrawer, NavigationView.OnNavigationItemSelectedListener {

  private BaseActivity baseActivity;

  private DrawerLayout drawerLayout;
  private NavigationView navigationView;
  private ImageView summonerIconImageView;
  private TextView summonerNameTextView;
  private TextView summonerLevelTextView;

  // TODO dont store data here
  private Summoner summoner;

  @Inject public NavigationDrawerImpl(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.home:
        Timber.d("Home clicked");
        baseActivity.getNavigator().showStartFragment();
        break;
      case R.id.match_history:
        if (summoner != null) {
          baseActivity.getNavigator().showMatchhistoryFragment(summoner);
        } else {
          baseActivity.getActivityComponent()
              .snackbarController()
              .showError("No summoner selected.");
        }
        Timber.d("Match History clicked");
        break;
      case R.id.league_position:
        if (summoner != null) {
          baseActivity.getNavigator().showLeaguePositionFragment(summoner);
        } else {
          baseActivity.getActivityComponent()
              .snackbarController()
              .showError("No summoner selected.");
        }
        Timber.d("League Positon clicked");
        break;
      case R.id.settings:
        baseActivity.getNavigator().showSettingsFragment();
        Timber.d("Settings clicked");
        break;
    }
    drawerLayout.closeDrawer(Gravity.START);
    return false;
  }

  @Override public void setDrawerLayout(Toolbar toolbar) {
    if (drawerLayout == null && toolbar != null) {
      drawerLayout = baseActivity.findViewById(R.id.drawer_layout);
      navigationView = baseActivity.findViewById(R.id.navigation_view);
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.setCheckedItem(R.id.home);

      ActionBarDrawerToggle drawerToggle =
          new ActionBarDrawerToggle(baseActivity, this.drawerLayout, toolbar,
              R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      drawerLayout.setStatusBarBackgroundColor(
          baseActivity.getResources().getColor(R.color.colorPrimaryDark));
      drawerLayout.addDrawerListener(drawerToggle);
      drawerToggle.syncState();

      View headerLayout = navigationView.getHeaderView(0);
      summonerIconImageView =
          headerLayout.findViewById(R.id.navigation_header_summoner_icon_imageview);
      summonerNameTextView =
          headerLayout.findViewById(R.id.navigation_header_summoner_name_textview);
      summonerLevelTextView =
          headerLayout.findViewById(R.id.navigation_header_summoner_level_textview);
    }
  }

  @Override public boolean closeWhenOpened() {
    if (drawerLayout.isDrawerOpen(Gravity.START)) {
      drawerLayout.closeDrawer(Gravity.START);
      return true;
    } else {
      return false;
    }
  }

  @Override public void setNavigationDrawerHeaderData(Summoner summoner) {
    this.summoner = summoner;
    if (baseActivity != null && summoner != null) {
      baseActivity.getActivityComponent()
          .imageLoaderController()
          .loadProfileIcon(summoner.profileIconId, summonerIconImageView, true);
      summonerNameTextView.setText(summoner.name);
      summonerLevelTextView.setText("Level " + String.valueOf(summoner.summonerLevel));
    }
  }

  @Override public void setCheckedItem(int itemId) {
    if (navigationView != null) {
      navigationView.setCheckedItem(itemId);
    }
  }
}
