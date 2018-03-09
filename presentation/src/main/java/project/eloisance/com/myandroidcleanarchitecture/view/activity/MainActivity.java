package project.eloisance.com.myandroidcleanarchitecture.view.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import project.eloisance.com.myandroidcleanarchitecture.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
