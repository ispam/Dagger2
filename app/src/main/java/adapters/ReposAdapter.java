package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

import destinum.tech.a1dagger2.R;
import models.GithubRepo;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<GithubRepo> mRepoArrayList;

    public ReposAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.format_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ReposAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mRepoArrayList != null ? mRepoArrayList.size() : 0;
    }


    public void swapData(Collection<GithubRepo> githubRepos){
        mRepoArrayList.clear();
        if (githubRepos != null){
            mRepoArrayList.addAll(githubRepos);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v) {
            super(v);

            TextView name, desc, stars, issues, forks;
            ImageView image;

            name = v.findViewById(R.id.repo_name);
            desc = v.findViewById(R.id.repo_desc);
            stars = v.findViewById(R.id.repo_stars);
            issues = v.findViewById(R.id.repo_issues);
            forks = v.findViewById(R.id.repo_forks);
            image = v.findViewById(R.id.imageView);
        }
    }
}
