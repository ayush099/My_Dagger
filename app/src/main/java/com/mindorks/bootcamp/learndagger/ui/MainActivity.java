package com.mindorks.bootcamp.learndagger.ui;


import android.os.Bundle;
import android.widget.TextView;
import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;
import javax.inject.Inject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    int CONTENT_VIEW_ID = 10101010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies();
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
        {
            HomeFragment myFragment = new HomeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment1, myFragment);
            fragmentTransaction.commit();
        }

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(viewModel.getSomeData());
    }

    public void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

    }
}
