package de.g00fy2.justdoit.app.fragments.league_position;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.league_position.LeaguePositionAdapter;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.annotations.Title;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.fragments.base.BaseFragment;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.model.utils.LeagueAPIUtils;
import de.g00fy2.model.models.LeaguePosition;
import de.g00fy2.model.models.Summoner;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 05.12.2017.
 */

@Layout(R.layout.fragment_league_position) @Title(R.string.league_position)
public class LeaguePositionFragment extends BaseFragment
    implements LeaguePositionContract.LeaguePositionView {

  private LeaguePositionAdapter leaguePositionAdapter;

  @Inject ImageLoaderController imageLoaderController;
  @Inject LeaguePositionContract.LeaguePositionPresenter presenter;

  @BindView(R.id.league_position_profile_imageview) ImageView leaguePositionProfileImageView;
  @BindView(R.id.league_position_profile_textview) TextView leaguePositionProfileTextView;
  @BindView(R.id.league_position_league_textview) TextView leaguePositionLeagueTextView;
  @BindView(R.id.league_position_league_name_textview) TextView leaguePositionNameTextView;
  @BindViews({
      R.id.league_position_division_1_cardview, R.id.league_position_division_2_cardview,
      R.id.league_position_division_3_cardview, R.id.league_position_division_4_cardview,
      R.id.league_position_division_5_cardview
  }) List<CardView> leaguePositionDivisionCardViews;
  @BindView(R.id.league_position_recyclerview) RecyclerView leaguePositionRecyclerView;

  @OnClick({
      R.id.league_position_division_1_cardview, R.id.league_position_division_2_cardview,
      R.id.league_position_division_3_cardview, R.id.league_position_division_4_cardview,
      R.id.league_position_division_5_cardview
  }) public void onDivisionClicked(CardView cardView) {
    try {
      int division = Integer.parseInt((String) cardView.getTag());
      loadDivision(division);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override protected void initializeViews() {
    leaguePositionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    leaguePositionRecyclerView.setHasFixedSize(true);
    leaguePositionAdapter = new LeaguePositionAdapter(presenter);
    leaguePositionRecyclerView.setAdapter(leaguePositionAdapter);
  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }

  @Override public void dataChanged() {
    leaguePositionAdapter.notifyDataSetChanged();
  }

  @Override public void setSummonerData(Summoner summoner) {
    if (summoner != null) {
      imageLoaderController.loadProfileIcon(summoner.profileIconId, leaguePositionProfileImageView,
          true);
      leaguePositionProfileTextView.setText(summoner.name);
    }
  }

  @Override public void setLeagueData(LeaguePosition leaguePosition) {
    if (leaguePosition != null) {
      leaguePositionLeagueTextView.setText(
          leaguePosition.tier + " " + LeagueAPIUtils.transformRankToString(leaguePosition.rank));
      leaguePositionNameTextView.setText(leaguePosition.leagueName);
      int rank = leaguePosition.rank;
      if (rank > 0 && rank < leaguePositionDivisionCardViews.size()) {
        leaguePositionDivisionCardViews.get(rank - 1)
            .setCardBackgroundColor(ContextCompat.getColor(getBaseActivity(), R.color.colorAccent));
      }
    }
  }

  private void loadDivision(int division) {
    presenter.loadDivision(division);
    for (CardView cardView : leaguePositionDivisionCardViews) {
      if (cardView.getTag().equals(String.valueOf(division))) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(getBaseActivity(), R.color.colorAccent));
      } else {
        cardView.setCardBackgroundColor(Color.WHITE);
      }
    }
  }
}
