package de.g00fy2.justdoit.app;

import android.app.Application;
import de.g00fy2.justdoit.BuildConfig;
import de.g00fy2.justdoit.app.di.ApplicationComponent;
import de.g00fy2.justdoit.app.di.ApplicationModule;
import de.g00fy2.justdoit.app.di.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * Created by Thomas Wirth on 04.10.2017.
 */

public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
