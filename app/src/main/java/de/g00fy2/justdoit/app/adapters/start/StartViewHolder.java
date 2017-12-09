package de.g00fy2.justdoit.app.adapters.start;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.adapters.base.BaseViewHolder;
import de.g00fy2.justdoit.app.fragments.start.StartContract;
import de.g00fy2.model.models.Summoner;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public class StartViewHolder extends BaseViewHolder<StartContract.StartPresenter> {

  @BindView(R.id.item_favourite_summoner_textview) TextView summonerTextView;
  @BindView(R.id.item_favourite_summoner_delete_textview) TextView deleteTextView;

  @OnClick(R.id.item_favourite_summoner_textview) void onNameClick(View view) {
    onItemClickListener.onItemClicked(view, getAdapterPosition());
  }

  @OnClick(R.id.item_favourite_summoner_delete_textview) void onDeleteClick(View view) {
    onItemClickListener.onItemClicked(view, getAdapterPosition());
  }

  public StartViewHolder(View view, BaseAdapter.OnItemClickListener onItemClickListener) {
    super(view);
    super.onItemClickListener = onItemClickListener;
  }

  @Override public void setDataInViews(StartContract.StartPresenter presenter) {
    Summoner summoner = presenter.getSummonerInPosition(getAdapterPosition());

    summonerTextView.setText(summoner.name);
    deleteTextView.setTag("delete");
  }
}
