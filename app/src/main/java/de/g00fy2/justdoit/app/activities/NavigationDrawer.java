package de.g00fy2.justdoit.app.activities;

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
import butterknife.Unbinder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.utils.APIUtils;
import de.g00fy2.model.models.Summoner;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 19.11.2017.
 */

public class NavigationDrawer implements NavigationView.OnNavigationItemSelectedListener, Unbinder {

  private BaseActivity baseActivity;

  private DrawerLayout drawerLayout;
  private ImageView summonerIconImageView;
  private TextView summonerNameTextView;
  private TextView summonerLevelTextView;

  @Inject public NavigationDrawer(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  void setDrawerLayout(Toolbar toolbar) {
    if (drawerLayout == null && toolbar != null) {
      drawerLayout = baseActivity.findViewById(R.id.drawer_layout);
      NavigationView navigationView = baseActivity.findViewById(R.id.navigation_view);
      navigationView.setNavigationItemSelectedListener(this);

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

  Boolean closeWhenOpened() {
    if (drawerLayout.isDrawerOpen(Gravity.START)) {
      drawerLayout.closeDrawer(Gravity.START);
      return true;
    } else {
      return false;
    }
  }

  public void setNavigationDrawerHeaderData(Summoner summoner) {
    if (baseActivity != null && summoner != null) {
      Glide.with(baseActivity)
          .load(APIUtils.generateProfileIconUrl(summoner.profileIconId))
          .apply(RequestOptions.circleCropTransform())
          .into(summonerIconImageView);
      summonerNameTextView.setText(summoner.name);
      summonerLevelTextView.setText("Level " + String.valueOf(summoner.summonerLevel));
    }
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.home:
        Timber.d("Home clicked");
      case R.id.favourites:
        Timber.d("Favourites clicked");
        break;
      case R.id.settings:
        Timber.d("Settings clicked");
        break;
      case R.id.info:
        Timber.d("Info clicked");
        break;
    }
    drawerLayout.closeDrawer(Gravity.START);
    return true;
  }

  @Override public void unbind() {
    if (baseActivity == null) throw new IllegalStateException("Bindings already cleared.");
    this.baseActivity = null;

    drawerLayout = null;
    summonerIconImageView = null;
    summonerNameTextView = null;
    summonerLevelTextView = null;
  }
}
