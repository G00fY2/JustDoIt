package de.g00fy2.justdoit.app.adapters.leagueposition;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseViewHolder;
import de.g00fy2.justdoit.app.fragments.leagueposition.LeaguePositionContract;
import de.g00fy2.model.utils.LeagueAPIUtils;
import de.g00fy2.model.models.LeagueItem;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

public class LeaguePositionViewHolder
    extends BaseViewHolder<LeaguePositionContract.LeaguePositionPresenter> {

  @BindView(R.id.league_position_rank_textview) TextView rankTextView;
  @BindView(R.id.league_position_name_textview) TextView nameTextView;
  @BindView(R.id.league_position_points_textview) TextView pointsTextView;

  public LeaguePositionViewHolder(View view) {
    super(view);
  }

  @Override public void setDataInViews(LeaguePositionContract.LeaguePositionPresenter presenter) {
    LeagueItem leagueItem = presenter.getLeaguePositionInPosition(getAdapterPosition());

    rankTextView.setText(LeagueAPIUtils.transformRankToString(leagueItem.rank));
    nameTextView.setText(leagueItem.playerOrTeamName);
    pointsTextView.setText(String.valueOf(leagueItem.leaguePoints));
  }
}
