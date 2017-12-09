package de.g00fy2.justdoit.app.adapters.start;

import android.view.ViewGroup;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.fragments.start.StartContract;

/**
 * Created by Thomas Wirth on 29.11.2017.
 */

public class StartAdapter extends BaseAdapter<StartContract.StartPresenter, StartViewHolder> {

  public StartAdapter(StartContract.StartPresenter presenter) {
    super(presenter);
  }

  @Override public StartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new StartViewHolder(inflate(parent, R.layout.item_favourite_summoner),
        onItemClickListener);
  }

  @Override public void onBindViewHolder(StartViewHolder holder, int position) {
    holder.setDataInViews(getPresenter());
  }

  @Override public int getItemCount() {
    return getPresenter().getDataSize();
  }
}
