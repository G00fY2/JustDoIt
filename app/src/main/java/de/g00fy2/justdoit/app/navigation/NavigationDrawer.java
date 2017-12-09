package de.g00fy2.justdoit.app.navigation;

import android.support.v7.widget.Toolbar;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

public interface NavigationDrawer {

  void setDrawerLayout(Toolbar toolbar);

  boolean closeWhenOpened();

  void setNavigationDrawerHeaderData(Summoner summoner);

  void setCheckedItem(int itemId);
}
