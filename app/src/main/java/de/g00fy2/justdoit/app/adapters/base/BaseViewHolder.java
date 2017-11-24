package de.g00fy2.justdoit.app.adapters.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;
import de.g00fy2.justdoit.app.fragments.base.BasePresenter;

/**
 * Created by Thomas Wirth on 22.11.2017.
 */

public abstract class BaseViewHolder<Presenter extends BasePresenter>
    extends RecyclerView.ViewHolder {

  public BaseViewHolder(View view) {
    super(view);
    ButterKnife.bind(this, view);
  }

  public abstract void setDataInViews(Presenter presenter);
}