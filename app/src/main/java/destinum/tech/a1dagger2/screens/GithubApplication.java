package destinum.tech.a1dagger2.screens;

import android.app.Activity;
import android.app.Application;

import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import destinum.tech.a1dagger2.BuildConfig;
import network.GithubService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubApplication extends Application {

    public static GithubApplication get(Activity activity){
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githutService;

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //CAREFUL Only use Logging Interceptor in development!!
        if (BuildConfig.DEBUG){
            okHttpClient.addInterceptor(interceptor);
        }

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient.build()))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .baseUrl("https://api.github.com/")
                .build();

        githutService = retrofit.create(GithubService.class);


    }

    public GithubService getGithutService(){
        return githutService;
    }
}
