package de.g00fy2.justdoit.app.fragments.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.View;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.annotations.Title;
import java.lang.annotation.Annotation;

/**
 * Created by Thomas Wirth on 08.12.2017.
 */

public abstract class BasePreferenceFragment extends PreferenceFragmentCompat implements BaseView {

  private BasePresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.presenter = registerPresenter();
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initializeViews();
    if (presenter != null) {
      presenter.onCreate();
    }
  }

  @Override public void onResume() {
    super.onResume();

    if (presenter != null) {
      presenter.onResume();
    }

    ActionBar toolbar = getBaseActivity().getSupportActionBar();
    if (toolbar != null) {
      toolbar.setTitle(setTitle());
    }
  }

  @Override public void onPause() {
    super.onPause();
    if (presenter != null) {
      presenter.onPause();
    }
  }
  protected abstract void initializeViews();


  protected abstract BasePresenter registerPresenter();


  private String setTitle() {
    Annotation annotation = this.getClass().getAnnotation(Title.class);
    if (annotation != null && getContext() != null) {
      int stringResId = ((Title) annotation).value();
      return getContext().getString(stringResId);
    }

    return "";
  }

  protected BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }
}