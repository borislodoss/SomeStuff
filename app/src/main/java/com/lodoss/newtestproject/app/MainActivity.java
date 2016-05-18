package com.lodoss.newtestproject.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.gson.Gson;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.io.*;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = (RecyclerView) findViewById(R.id.list);

        

        Observable.just(R.raw.list)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        InputStream inputStream = getResources().openRawResource(R.raw.list);
                        StringBuilder sb=new StringBuilder();
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                        String read;

                        try {
                            while((read=br.readLine()) != null) {
                                //System.out.println(read);
                                sb.append(read);
                            }

                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            return "";
                        }

                        return sb.toString();
                    }
                })
                .map(new Func1<String, ListObject>() {
                    @Override
                    public ListObject call(String jsonStr) {
                        Gson gson = new Gson();
                        return gson.fromJson(jsonStr, ListObject.class);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ListObject>() {
                    @Override
                    public void call(ListObject listObject) {
                        List<Item> results = listObject.getResults();
                        CustomAdapter adapter = new CustomAdapter(MainActivity.this, results, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Item item = (Item) view.getTag();
                                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                                intent.putExtra(DetailActivity.ARG_ITEM, item);
                                startActivity(intent);
                            }
                        });
                        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                        mList.setLayoutManager(llm);
                        mList.setAdapter(adapter);
                    }
                });
    }
}
