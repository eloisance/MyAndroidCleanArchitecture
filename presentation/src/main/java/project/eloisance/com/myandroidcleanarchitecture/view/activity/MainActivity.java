package project.eloisance.com.myandroidcleanarchitecture.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.eloisance.com.myandroidcleanarchitecture.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
}
