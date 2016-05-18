package com.lodoss.newtestproject.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Boris on 18/05/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    private LayoutInflater mInflater;
    private List<Item> itemList;
    private View.OnClickListener onItemClickListener;

    public CustomAdapter(Context c, List<Item> itemList, View.OnClickListener onItemClickListener){
        mInflater = LayoutInflater.from(c);
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(0);
        holder.title.setText(item.getTitle());
        holder.text.setText(Html.fromHtml(item.getHtml()));
        holder.itemView.setTag(item);
        holder.itemView.setOnClickListener(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
