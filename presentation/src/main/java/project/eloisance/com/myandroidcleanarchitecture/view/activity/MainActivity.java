package project.eloisance.com.myandroidcleanarchitecture.view.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.eloisance.com.myandroidcleanarchitecture.R;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.HasComponent;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.components.DaggerUserComponent;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.components.UserComponent;
import project.eloisance.com.myandroidcleanarchitecture.model.UserModel;
import project.eloisance.com.myandroidcleanarchitecture.view.fragment.UserListFragment;

public class MainActivity extends BaseActivity implements HasComponent<UserComponent>, UserListFragment.UserListListener {

    private static final String TAG = "MainActivity";

    private UserComponent userComponent;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new UserListFragment());
        }

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_bottom_1:
                    Log.d(TAG, "item 1");
                    this.navigator.navigateToUserList(getApplicationContext());
                    break;
                case R.id.action_bottom_2:
                    Log.d(TAG, "item 2");
                    this.navigator.navigateToUserList(getApplicationContext());
                    break;
                case R.id.action_bottom_3:
                    Log.d(TAG, "item 3");
                    this.navigator.navigateToUserList(getApplicationContext());
                    break;
            }
            return true;
        });
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }

    @Override
    public void onUserClicked(UserModel userModel) {
        this.navigator.navigateToUserDetails(this, userModel.getUserId());
    }
}
