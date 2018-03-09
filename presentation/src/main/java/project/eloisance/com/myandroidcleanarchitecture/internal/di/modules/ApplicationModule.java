package project.eloisance.com.myandroidcleanarchitecture.internal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import project.eloisance.com.data.executor.JobExecutor;
import project.eloisance.com.data.repository.UserDataRepository;
import project.eloisance.com.domain.executor.PostExecutionThread;
import project.eloisance.com.domain.executor.ThreadExecutor;
import project.eloisance.com.domain.repository.UserRepository;
import project.eloisance.com.myandroidcleanarchitecture.AndroidApplication;
import project.eloisance.com.myandroidcleanarchitecture.UIThread;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
