package com.training.christian.pocketlink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PocketListActivity extends AppCompatActivity {

    @BindView(R.id.activity_pocket_list)
    RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_list);
        ButterKnife.bind(this);

        //Wyswietlanie elementow w pionie, jeden za drugim
        mList.setLayoutManager(new LinearLayoutManager(this));

        iLinkDataBase dataBase = new SqlLiteLinkDatabase(this);
        LinksAdapter adapter = new LinksAdapter(dataBase.getLinks());

        mList.setAdapter(adapter);
    }
}
