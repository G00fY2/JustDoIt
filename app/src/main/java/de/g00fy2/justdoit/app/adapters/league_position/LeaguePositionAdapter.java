package de.g00fy2.justdoit.app.adapters.league_position;

import android.view.ViewGroup;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.fragments.league_position.LeaguePositionContract;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class LeaguePositionAdapter
    extends BaseAdapter<LeaguePositionContract.LeaguePositionPresenter, LeaguePositionViewHolder> {

  public LeaguePositionAdapter(LeaguePositionContract.LeaguePositionPresenter presenter) {
    super(presenter);
  }

  @Override public LeaguePositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new LeaguePositionViewHolder(inflate(parent, R.layout.item_league_position));
  }

  @Override public void onBindViewHolder(LeaguePositionViewHolder holder, int position) {
    holder.setDataInViews(getPresenter());
  }

  @Override public int getItemCount() {
    return getPresenter().getDataSize();
  }
}
