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
import javax.inject.Inject;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.fragment_start) @Title(R.string.app_name) public class StartFragment
    extends BaseFragment implements StartContract.StartView {

  @Inject StartContract.StartPresenter presenter;

  @BindView(R.id.summoner_name_edittext) EditText summonerNameEditText;
  @BindView(R.id.start_current_version_textview) TextView currentVersionTextView;

  @OnClick(R.id.search_summoner_textview) void onSearchSummonerClick() {
    presenter.searchSummoner(summonerNameEditText.getText().toString());
  }

  @Override protected void initializeViews() {

  }

  @Override protected BasePresenter registerPresenter() {
    return presenter;
  }

  @Override public void showCurrentVersion(String currentVersion) {
    currentVersionTextView.setText(currentVersion);
  }
}
