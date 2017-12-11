package de.g00fy2.justdoit.app.adapters.matchhistory;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.BindViews;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseViewHolder;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryContract;
import de.g00fy2.model.models.Match;
import de.g00fy2.model.utils.LeagueAPIUtils;
import java.util.List;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public class MatchhistoryViewHolder
    extends BaseViewHolder<MatchhistoryContract.MatchhistoryPresenter> {

  private ImageLoaderController imageLoaderController;

  @BindView(R.id.item_matchhistroy_root_cardview) CardView rootCardView;
  @BindView(R.id.item_matchhistroy_matchtype) TextView matchtypeTextview;
  @BindView(R.id.item_matchhistroy_duration) TextView durationTextview;
  @BindView(R.id.item_matchhistroy_champion_imageview) ImageView championImageView;
  @BindView(R.id.item_matchhistroy_summonerspell_1) ImageView summonerspell1ImageView;
  @BindView(R.id.item_matchhistroy_summonerspell_2) ImageView summonerspell2ImageView;
  @BindView(R.id.item_matchhistroy_champion_textview) TextView championNameTextView;
  @BindView(R.id.item_matchhistroy_kda) TextView kdaTextView;
  @BindViews({
      R.id.item_matchhistroy_summoner1_textview, R.id.item_matchhistroy_summoner2_textview,
      R.id.item_matchhistroy_summoner3_textview, R.id.item_matchhistroy_summoner4_textview,
      R.id.item_matchhistroy_summoner5_textview, R.id.item_matchhistroy_summoner6_textview,
      R.id.item_matchhistroy_summoner7_textview, R.id.item_matchhistroy_summoner8_textview,
      R.id.item_matchhistroy_summoner9_textview, R.id.item_matchhistroy_summoner10_textview,
  }) List<TextView> summonersTextViews;
  @BindViews({
      R.id.item_matchhistroy_summoner1_imageview, R.id.item_matchhistroy_summoner2_imageview,
      R.id.item_matchhistroy_summoner3_imageview, R.id.item_matchhistroy_summoner4_imageview,
      R.id.item_matchhistroy_summoner5_imageview, R.id.item_matchhistroy_summoner6_imageview,
      R.id.item_matchhistroy_summoner7_imageview, R.id.item_matchhistroy_summoner8_imageview,
      R.id.item_matchhistroy_summoner9_imageview, R.id.item_matchhistroy_summoner10_imageview,
  }) List<ImageView> summonersImageViews;

  public MatchhistoryViewHolder(View view, ImageLoaderController imageLoaderController) {
    super(view);
    this.imageLoaderController = imageLoaderController;
  }

  @Override public void setDataInViews(MatchhistoryContract.MatchhistoryPresenter presenter) {
    Match match = presenter.getMatchInPosition(getAdapterPosition());
    matchtypeTextview.setText(LeagueAPIUtils.queueIdToGamemode(match.queueId));
    rootCardView.setCardBackgroundColor(
        match.participants.get(match.playerParticipantsIndex).win.toLowerCase().equals("win")
            ? ContextCompat.getColor(this.itemView.getContext(), R.color.win)
            : ContextCompat.getColor(this.itemView.getContext(), R.color.loss));
    durationTextview.setText(LeagueAPIUtils.transfromGameDuration(match.gameDuration) + " min");
    championNameTextView.setText(
        match.participants.get(match.playerParticipantsIndex).championName);
    kdaTextView.setText(
        LeagueAPIUtils.buildKDAString(match.participants.get(match.playerParticipantsIndex)));

    imageLoaderController.loadChampionIcon(
        match.participants.get(match.playerParticipantsIndex).championKey, championImageView, true);
    imageLoaderController.loadSpellIcon(
        match.participants.get(match.playerParticipantsIndex).spell1Key, summonerspell1ImageView,
        false);
    imageLoaderController.loadSpellIcon(
        match.participants.get(match.playerParticipantsIndex).spell2Key, summonerspell2ImageView,
        false);

    setSummonersData(match);
  }

  private void setSummonersData(Match match) {
    int summonerCount = match.participants.size();
    int offset = (10 - summonerCount) / 2;

    for (int i = 0; i < summonerCount; i++) {
      if (summonerCount == 10) {
        summonersTextViews.get(i).setText(match.participants.get(i).summonerName);
        imageLoaderController.loadChampionIcon(match.participants.get(i).championKey,
            summonersImageViews.get(i), true);
      } else {
        if (i + 1 > summonerCount / 2) {
          summonersTextViews.get(i + offset).setText(match.participants.get(i).summonerName);
          imageLoaderController.loadChampionIcon(match.participants.get(i + offset).championKey,
              summonersImageViews.get(i), true);
        }
      }
    }
  }
}
