package de.g00fy2.justdoit.app.di;

import dagger.Component;
import de.g00fy2.justdoit.app.MyApplication;
import javax.inject.Singleton;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    MyApplication application();
}
