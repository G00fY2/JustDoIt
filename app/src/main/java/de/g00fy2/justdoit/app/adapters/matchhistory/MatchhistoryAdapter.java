package de.g00fy2.justdoit.app.adapters.matchhistory;

import android.view.ViewGroup;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.fragments.matchhistory.MatchhistoryContract;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public class MatchhistoryAdapter
    extends BaseAdapter<MatchhistoryContract.MatchhistoryPresenter, MatchhistoryViewHolder> {

  private ImageLoaderController imageLoaderController;

  public MatchhistoryAdapter(MatchhistoryContract.MatchhistoryPresenter presenter,
      ImageLoaderController imageLoaderController) {
    super(presenter);
    this.imageLoaderController = imageLoaderController;
  }

  @Override public MatchhistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MatchhistoryViewHolder(inflate(parent, R.layout.item_matchhistory), imageLoaderController);
  }

  @Override public void onBindViewHolder(MatchhistoryViewHolder holder, int position) {
    holder.setDataInViews(getPresenter());
  }

  @Override public int getItemCount() {
    return getPresenter().getDataSize();
  }
}
