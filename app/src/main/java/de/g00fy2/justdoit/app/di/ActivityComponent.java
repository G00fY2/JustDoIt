package de.g00fy2.justdoit.app.di;

import android.content.Context;
import dagger.Component;
import de.g00fy2.justdoit.app.Navigator;
import de.g00fy2.justdoit.app.activities.BaseActivity;
import de.g00fy2.justdoit.app.annotations.PerActivity;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@PerActivity
@Component(modules = {ActivityModule.class}, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    BaseActivity baseActivity();

    Context context();

    Navigator navigator();
}
