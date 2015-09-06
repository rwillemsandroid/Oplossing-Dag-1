package be.vdab.simplelayout.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.models.ListItemModel;

/**
 * Created by RWIL on 04/09/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItemModel> mDataList;
    Context mContext;

    public MyAdapter(List mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitleTextView.setText(mDataList.get(position).getmTitle());
        holder.mContentTextView.setText(mDataList.get(position).getmContent());
        Picasso.with(mContext).load(mDataList.get(position).getmUrl()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitleTextView;
        public TextView mContentTextView;
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.listitem_title);
            mContentTextView = (TextView) itemView.findViewById(R.id.listitem_content);
            mImageView= (ImageView) itemView.findViewById(R.id.listitem_image);
        }
    }
}
