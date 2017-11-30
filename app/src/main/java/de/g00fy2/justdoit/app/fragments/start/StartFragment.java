package de.g00fy2.justdoit.app.fragments.start;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.adapters.base.BaseAdapter;
import de.g00fy2.justdoit.app.adapters.start.StartAdapter;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.annotations.Title;
import de.g00fy2.justdoit.app.fragments.base.BaseFragment;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;
import de.g00fy2.model.models.Summoner;
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.fragment_start) @Title(R.string.app_name) public class StartFragment
    extends BaseFragment implements StartContract.StartView, BaseAdapter.OnItemClickListener {

  private StartAdapter startAdapter;

  @Inject StartContract.StartPresenter presenter;

  @BindView(R.id.start_current_version_textview) TextView currentVersionTextView;
  @BindView(R.id.searchView) SearchView summonerSearchView;
  @BindView(R.id.recyclerView) RecyclerView summonerRecylerView;

  @Override protected void initializeViews() {

    summonerRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    summonerRecylerView.setHasFixedSize(true);
    startAdapter = new StartAdapter(presenter);
    startAdapter.setOnItemClickListener(this);
    summonerRecylerView.setAdapter(startAdapter);

    summonerSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        presenter.searchSummoner(summonerSearchView.getQuery().toString());
        summonerSearchView.clearFocus();
        return true;
      }

      @Override public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }

  @Override public void showCurrentVersion(String currentVersion) {
    currentVersionTextView.setText(currentVersion);
  }

  @Override public void setDefaultSummoner(Summoner summoner) {
    getBaseActivity().getNavigationDrawer().setNavigationDrawerHeaderData(summoner);
  }

  @Override public void notifyDataChanged() {
    startAdapter.notifyDataSetChanged();
  }

  @Override public void onItemClicked(View view, int position) {
    presenter.openMatchhistory(position);
  }
}
