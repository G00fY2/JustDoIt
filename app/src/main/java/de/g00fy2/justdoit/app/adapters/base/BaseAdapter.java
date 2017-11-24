package de.g00fy2.justdoit.app.adapters.base;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public abstract class BaseAdapter<Presenter extends BasePresenter, ViewHolder extends BaseViewHolder<Presenter>>
    extends RecyclerView.Adapter<ViewHolder> {

  private final Presenter presenter;

  public BaseAdapter(Presenter presenter) {
    this.presenter = presenter;
  }

  protected Presenter getPresenter() {
    return presenter;
  }

  protected View inflate(ViewGroup parent, @LayoutRes int layout) {
    return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
  }
}