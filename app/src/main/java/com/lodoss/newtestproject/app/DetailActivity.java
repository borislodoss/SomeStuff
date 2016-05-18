package com.lodoss.newtestproject.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {

    public static final String ARG_ITEM = "arg_item";

    private ViewHolder mViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mViewHolder = new ViewHolder(this);

        Item item = getIntent().getExtras().getParcelable(ARG_ITEM);

        mViewHolder.title.setText(item.getTitle());
        mViewHolder.text.setText(Html.fromHtml(item.getHtml()));
    }

    public static final class ViewHolder {

        public TextView title;
        public TextView text;

        public ViewHolder(Activity a) {

            title = (TextView) a.findViewById(R.id.title);
            text = (TextView) a.findViewById(R.id.text);
        }
    }
}
