package be.vdab.simplelayout.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import be.vdab.simplelayout.R;
import be.vdab.simplelayout.models.database.Book;

/**
 * Created by RWIL on 09/09/2015.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.Viewholder> {

    private List<Book> mDataset;
    private Context mContext;

    public BookAdapter(List<Book> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_book, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.mTitle.setText(mDataset.get(position).getTitle());
        holder.mAuthor.setText(mDataset.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void updateDataList(List<Book>mDataset){
        this.mDataset=mDataset;
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public TextView mAuthor;
        public TextView mTitle;

        public Viewholder(View itemView) {
            super(itemView);

            mAuthor = (TextView) itemView.findViewById(R.id.listitem_book_et_author);
            mTitle = (TextView) itemView.findViewById(R.id.listitem_book_et_title);
        }
    }
}
