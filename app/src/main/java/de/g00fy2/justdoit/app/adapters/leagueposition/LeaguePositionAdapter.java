package de.g00fy2.justdoit.app.adapters.leagueposition;

import android.view.ViewGroup;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.fragments.leagueposition.LeaguePositionContract;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class LeaguePositionAdapter
    extends BaseAdapter<LeaguePositionContract.LeaguePositionPresenter, de.g00fy2.justdoit.app.adapters.leagueposition.LeaguePositionViewHolder> {

  public LeaguePositionAdapter(LeaguePositionContract.LeaguePositionPresenter presenter) {
    super(presenter);
  }

  @Override public de.g00fy2.justdoit.app.adapters.leagueposition.LeaguePositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new de.g00fy2.justdoit.app.adapters.leagueposition.LeaguePositionViewHolder(inflate(parent, R.layout.item_league_position));
  }

  @Override public void onBindViewHolder(de.g00fy2.justdoit.app.adapters.leagueposition.LeaguePositionViewHolder holder, int position) {
    holder.setDataInViews(getPresenter());
  }

  @Override public int getItemCount() {
    return getPresenter().getDataSize();
  }
}
