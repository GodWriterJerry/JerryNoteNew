package com.example.administrator.jerrynote0503;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView search;
    private FloatingActionButton fab;
    private MyAdapter myAdapter;
    private RecyclerView recycler_view;
    private List<Note> data=new ArrayList<Note>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        myAdapter=new MyAdapter(data);
        recycler_view.setAdapter(myAdapter);
    }

    private void initData() {
        data.clear();
        List<Note> noteList= DataSupport.findAll(Note.class);
        for (int i = 0; i < noteList.size(); i++) {
            Note note=new Note();
            note.setTitle(noteList.get(i).getTitle());
            note.setContent(noteList.get(i).getContent());
            note.setDate(noteList.get(i).getDate());
            data.add(note);
            Log.d("dd", "initData.: "+noteList.get(i).getContent());
        }
    }

    private void initViews() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        search= (TextView) findViewById(R.id.search);
        fab= (FloatingActionButton) findViewById(R.id.fab);
        recycler_view= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutManager);
        click();
    }

    private void click() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"这是搜索",Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WriteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit:
                Toast.makeText(MainActivity.this,"这是编辑",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mag_kind:
                Toast.makeText(MainActivity.this,"这是管理类别",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        myAdapter.notifyDataSetChanged();
    }
}
