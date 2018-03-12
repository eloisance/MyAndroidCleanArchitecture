package project.eloisance.com.myandroidcleanarchitecture.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.eloisance.com.myandroidcleanarchitecture.R;
import project.eloisance.com.myandroidcleanarchitecture.model.UserModel;

/**
 * Adaptar that manages a collection of {@link UserModel}.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    public interface OnItemClickListener {
        void onUserItemClicked(UserModel userModel);
    }

    private List<UserModel> usersCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    UsersAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usersCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.usersCollection != null) ? this.usersCollection.size() : 0;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final UserModel userModel = this.usersCollection.get(position);
        holder.textViewTitle.setText(userModel.getName());
        holder.itemView.setOnClickListener(v -> {
            if (UsersAdapter.this.onItemClickListener != null) {
                UsersAdapter.this.onItemClickListener.onUserItemClicked(userModel);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setUsersCollection(Collection<UserModel> usersCollection) {
        this.validateUsersCollection(usersCollection);
        this.usersCollection = (List<UserModel>) usersCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<UserModel> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView textViewTitle;

        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}