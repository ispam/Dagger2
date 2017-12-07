package destinum.tech.a1dagger2.screens;

import android.app.Activity;
import android.app.Application;

import network.GithubService;

public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity){
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githutService;

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
