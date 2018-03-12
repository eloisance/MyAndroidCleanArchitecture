package project.eloisance.com.myandroidcleanarchitecture.internal.di.components;

import dagger.Component;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.PerActivity;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.modules.ActivityModule;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.modules.UserModule;
import project.eloisance.com.myandroidcleanarchitecture.view.fragment.UserDetailsFragment;
import project.eloisance.com.myandroidcleanarchitecture.view.fragment.UserListFragment;

/**
 * A scope {@link project.eloisance.com.myandroidcleanarchitecture.internal.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(UserListFragment userListFragment);
    void inject(UserDetailsFragment userDetailsFragment);
}