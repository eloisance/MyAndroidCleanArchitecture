package project.eloisance.com.myandroidcleanarchitecture.internal.di.components;

import android.app.Activity;

import dagger.Component;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.PerActivity;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.modules.ActivityModule;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link project.eloisance.com.myandroidcleanarchitecture.internal.di.PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
