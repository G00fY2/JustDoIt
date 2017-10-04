package de.g00fy2.justdoit.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import de.g00fy2.justdoit.R;
import de.g00fy2.justdoit.app.annotations.Layout;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Layout(R.layout.activity_main) public class MainActivity extends BaseActivity {

  @BindView(R.id.fragmentContainer) View fragmentContainer;

  @BindView(R.id.toolbar) Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void onResume() {
    super.onResume();
    toolbar.setTitle("JustDoIt");
    toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
    getNavigator().showStartFragment();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  @Override public int getFragmentContainerId() {
    return R.id.fragmentContainer;
  }

  @Override public View getFragmentContainer() {
    return fragmentContainer;
  }
}
