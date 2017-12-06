package de.g00fy2.justdoit.app.fragments.matchhistory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.matchhistory.MatchhistoryAdapter;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.annotations.Title;
import de.g00fy2.justdoit.app.controllers.ImageLoaderController;
import de.g00fy2.justdoit.app.fragments.base.BaseFragment;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

@Layout(R.layout.fragment_matchhistory) @Title(R.string.app_name) public class MatchhistoryFragment
    extends BaseFragment implements MatchhistoryContract.MatchhistoryView {

  private MatchhistoryAdapter matchhistoryAdapter;

  @Inject MatchhistoryContract.MatchhistoryPresenter presenter;
  @Inject ImageLoaderController imageLoaderController;

  @BindView(R.id.matchhistory_recyclerview) RecyclerView matchhistoryRecylerView;

  @Override protected void initializeViews() {
    matchhistoryRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    matchhistoryRecylerView.setHasFixedSize(true);
    matchhistoryAdapter = new MatchhistoryAdapter(presenter, imageLoaderController);
    matchhistoryRecylerView.setAdapter(matchhistoryAdapter);
  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }

  @Override public void dataChanged() {
    matchhistoryAdapter.notifyDataSetChanged();
  }
}
