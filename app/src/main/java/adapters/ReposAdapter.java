package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import destinum.tech.a1dagger2.R;
import models.GithubRepo;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<GithubRepo> mRepoArrayList;

    public ReposAdapter(Context context, ArrayList<GithubRepo> repoArrayList) {
        mContext = context;
        mRepoArrayList = repoArrayList;
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
