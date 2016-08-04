package com.sally.matrialcomdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sally.matrialcomdemo.R;
import com.sally.matrialcomdemo.bean.NewsBean;

import java.util.List;

/**
 * Created by sally on 8/4/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<NewsBean> mLists;
    private Context mContext;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(List<NewsBean> list, Context context) {
        this.mLists = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = mInflater.inflate(R.layout.item_recycler_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NewsBean newBean = mLists.get(position);
        holder.bookPhoto.setImageResource(newBean.getPicture());
        holder.bookName.setText(newBean.getTitle());
        holder.bookContent.setText(newBean.getContent());
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView bookPhoto;
    TextView bookName;
    TextView bookContent;

    public MyViewHolder(View itemView) {
        super(itemView);
        bookPhoto = (ImageView) itemView.findViewById(R.id.id_item_book_image);
        bookName = (TextView) itemView.findViewById(R.id.id_item_book_name);
        bookContent = (TextView) itemView.findViewById(R.id.id_item_book_content);
    }
}
