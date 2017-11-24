package de.g00fy2.justdoit.app.fragments.start;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import de.g00fy2.justdoit.R;
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
    extends BaseFragment implements StartContract.StartView {

  @Inject StartContract.StartPresenter presenter;

  @BindView(R.id.summoner_name_edittext) EditText summonerNameEditText;
  @BindView(R.id.start_current_version_textview) TextView currentVersionTextView;
  @BindView(R.id.open_matchhistory_textview) TextView openMatchhistoryTextView;

  @OnClick(R.id.search_summoner_textview) void onSearchSummonerClick() {
    presenter.searchSummoner(summonerNameEditText.getText().toString());
  }

  @OnClick(R.id.open_matchhistory_textview) void onSearchMatchesClick() {
    presenter.openMatchhistory();
  }

  @Override protected void initializeViews() {

  }

  @Override public void onResume() {
    super.onResume();
    summonerNameEditText.setText("");
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

  @Override public void activateMatchsearch(boolean activate) {
    openMatchhistoryTextView.setEnabled(activate);
    openMatchhistoryTextView.setAlpha(activate ? 1f : 0.5f);
  }
}
