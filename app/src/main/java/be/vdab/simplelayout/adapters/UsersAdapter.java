package be.vdab.simplelayout.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.models.retrofit.User;

/**
 * Created by RWIL on 07/09/2015.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private List<User> mDatalist;

    public UsersAdapter( List<User> mDatalist) {
        this.mDatalist=mDatalist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_users, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User thisUser = mDatalist.get(position);
        holder.mId.setText(thisUser.getId()+"");
        holder.mEmail.setText(thisUser.getEmail());
        holder.mUserName.setText(thisUser.getUsername());
        holder.mName.setText(thisUser.getName());
    }

    @Override
    public int getItemCount() {
        return mDatalist.size();
    }

    public void setDataList(List<User> userList) {
        this.mDatalist =userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mId;
        public TextView mName;
        public TextView mUserName;
        public TextView mEmail;


        public ViewHolder(View itemView) {
            super(itemView);
            mId= (TextView) itemView.findViewById(R.id.listem_user_id);
            mName= (TextView) itemView.findViewById(R.id.listem_user_name);
            mUserName= (TextView) itemView.findViewById(R.id.listem_user_username);
            mEmail= (TextView) itemView.findViewById(R.id.listem_user_email);

        }
    }
}
