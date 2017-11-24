package de.g00fy2.justdoit.app.navigation;

import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 24.11.2017.
 */

public interface Navigator {

  void showStartFragment();

  void showMatchhistoryFragment(Summoner summoner);
}
