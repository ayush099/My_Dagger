package com.mindorks.bootcamp.learndagger.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class NetworkHelper
{
    // should be application context
    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext Context context)
    {
        this.context = context;

    }


    private boolean isNetworkConnected()
    {
        //check network connected using context
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
