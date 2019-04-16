package com.mindorks.bootcamp.learndagger.ui;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;
import javax.inject.Inject;

@ActivityScope
public class HomeViewModel
{
    private DatabaseService databaseService;
    private NetworkService networkService;
    private NetworkHelper networkHelper;

    @Inject
    public HomeViewModel(DatabaseService databaseService, NetworkService networkService, NetworkHelper networkHelper)
    {
        this.databaseService = databaseService;
        this.networkService = networkService;
        this.networkHelper = networkHelper;
    }

    public String getSomeDataHomeViewModel()
    {
        return databaseService.getDummyData() + " : " + networkService.getDummyData();
    }
}


