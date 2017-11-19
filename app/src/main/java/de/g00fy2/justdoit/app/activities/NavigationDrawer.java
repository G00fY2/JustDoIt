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

public class NavigationDrawer implements NavigationView.OnNavigationItemSelectedListener {

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
    int id = item.getItemId();
    if (id == R.id.home) {
      Timber.d("Home clicked");
    }
    drawerLayout.closeDrawer(Gravity.START);
    return true;
  }
}
