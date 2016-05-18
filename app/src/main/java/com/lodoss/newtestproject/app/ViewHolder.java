package com.lodoss.newtestproject.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Boris on 18/05/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView text;

    public ViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.title);
        text = (TextView) itemView.findViewById(R.id.text);
    }
}
