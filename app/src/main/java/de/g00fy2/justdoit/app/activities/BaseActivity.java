package de.g00fy2.justdoit.app.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.g00fy2.justdoit.app.MyApplication;
import de.g00fy2.justdoit.app.Navigator;
import de.g00fy2.justdoit.app.annotations.Layout;
import de.g00fy2.justdoit.app.di.components.ActivityComponent;
import de.g00fy2.justdoit.app.di.modules.ActivityModule;
import de.g00fy2.justdoit.app.di.components.DaggerActivityComponent;
import java.lang.annotation.Annotation;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

  protected ActivityComponent activityComponent;
  private Unbinder unbinder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(getLayoutResId());
    unbinder = ButterKnife.bind(this);
    initializeInjector();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }

  private void initializeInjector() {
    activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
        .activityModule(new ActivityModule(this))
        .build();
  }

  public ActivityComponent getActivityComponent() {
    return activityComponent;
  }

  public abstract int getFragmentContainerId();

  public abstract View getFragmentContainer();

  public Navigator getNavigator() {
    return activityComponent.navigator();
  }

  private int getLayoutResId() {
    Annotation annotation = ((Object) this).getClass().getAnnotation(Layout.class);
    if (annotation == null) {
      throw new IllegalArgumentException("No layout resource found");
    } else {
      return ((Layout) annotation).value();
    }
  }
}
