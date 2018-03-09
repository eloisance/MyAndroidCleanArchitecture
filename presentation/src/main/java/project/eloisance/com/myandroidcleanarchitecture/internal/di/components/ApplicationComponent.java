package project.eloisance.com.myandroidcleanarchitecture.internal.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import project.eloisance.com.domain.executor.PostExecutionThread;
import project.eloisance.com.domain.executor.ThreadExecutor;
import project.eloisance.com.domain.repository.UserRepository;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.modules.ApplicationModule;
import project.eloisance.com.myandroidcleanarchitecture.view.activity.BaseActivity;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    UserRepository userRepository();

}