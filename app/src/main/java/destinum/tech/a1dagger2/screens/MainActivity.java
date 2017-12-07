package destinum.tech.a1dagger2.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import adapters.ReposAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import destinum.tech.a1dagger2.R;
import models.GithubRepo;
import network.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.repo_home_list)
    private RecyclerView mRecyclerView;

    private GithubService mGithubService;

    private Call<List<GithubRepo>> mReposCall;

    private ReposAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new ReposAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mGithubService = GithubApplication.get(this).getGithutService();

        mReposCall = mGithubService.getAllRepos();
        mReposCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                mAdapter.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReposCall != null){
            mReposCall.cancel();
        }
    }
}
