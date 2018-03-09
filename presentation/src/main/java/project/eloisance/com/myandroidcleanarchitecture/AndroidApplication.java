package project.eloisance.com.myandroidcleanarchitecture;

import android.app.Application;

import project.eloisance.com.myandroidcleanarchitecture.internal.di.components.ApplicationComponent;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.components.DaggerApplicationComponent;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}