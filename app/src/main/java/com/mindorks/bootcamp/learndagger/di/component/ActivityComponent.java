package com.mindorks.bootcamp.learndagger.di.component;

import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.HomeFragment;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;

import androidx.fragment.app.Fragment;
import dagger.Component;

@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent
{
    void inject(MainActivity activity);

    void injectFragment(HomeFragment fragment);
}
