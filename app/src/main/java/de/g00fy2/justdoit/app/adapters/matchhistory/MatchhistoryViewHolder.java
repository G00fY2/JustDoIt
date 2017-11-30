package de.g00fy2.justdoit.app.adapters.matchhistory;

import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseViewHolder;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryContract;
import de.g00fy2.model.models.Match;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public class MatchhistoryViewHolder
    extends BaseViewHolder<MatchhistoryContract.MatchhistoryPresenter> {

  @BindView(R.id.matchhistory_item_textview) TextView matchhistoryTextView;

  public MatchhistoryViewHolder(View view) {
    super(view);
  }

  @Override public void setDataInViews(MatchhistoryContract.MatchhistoryPresenter presenter) {
    Match match = presenter.getMatchInPosition(getAdapterPosition());

    matchhistoryTextView.setText(match.gameMode);
    matchhistoryTextView.setBackgroundColor(
        ResourcesCompat.getColor(this.itemView.getContext().getResources(),
            (match.win.contains("Win")) ? R.color.win : R.color.loss, null));
  }
}
